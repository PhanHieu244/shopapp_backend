package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.SignUpResponse;
import vn.edu.hust.project.appledeviceservice.exception.UserEmailException;
import vn.edu.hust.project.appledeviceservice.mapper.UserResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.security.JwtTokenUtil;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUserUseCase {
    public static final Long DEFAULT_ROLE_MOD_ID = 3L;

    public static final Long DEFAULT_ROLE_USER_ID = 2L;


    private final IUserPort userPort;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;
    @Transactional(rollbackFor = Exception.class)
    public SignUpResponse createUser(CreateUserRequest request) {

        var existedUser = userPort.getUserByEmail(request.getEmail());

        if (existedUser != null) {
            log.error("[CreateUserUseCase] Email  existed");
            throw new UserEmailException();
        }

        var user = UserResourceMapper.INSTANCE.fromRequestToEntity(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(request.getRoleId() != null ? request.getRoleId() : DEFAULT_ROLE_MOD_ID);
        user = userPort.save(user);


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(), request.getPassword());
        authenticationManager.authenticate(authenticationToken);

        return new SignUpResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                jwtTokenUtil.generateToken(user)
        );

    }
    @Transactional(rollbackFor = Exception.class)
    public SignUpResponse createUserWeb(CreateUserWebRequest request) {

        var existedUser = userPort.getUserByEmail(request.getEmail());

        if (existedUser != null) {
            log.error("[CreateUserUseCase] Email  existed");
            throw new UserEmailException();
        }

        var user = UserResourceMapper.INSTANCE.fromRequestWebToEntity(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleId(DEFAULT_ROLE_USER_ID);
        user = userPort.save(user);


        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(), request.getPassword());
        authenticationManager.authenticate(authenticationToken);

        return new SignUpResponse(
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                jwtTokenUtil.generateToken(user)
        );

    }
}
