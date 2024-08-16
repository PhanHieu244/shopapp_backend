package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.LoginResponse;
import vn.edu.hust.project.appledeviceservice.exception.LoginException;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;
import vn.edu.hust.project.appledeviceservice.security.CustomUserDetails;
import vn.edu.hust.project.appledeviceservice.security.JwtTokenUtil;

@Service
@RequiredArgsConstructor
public class SignInUserUseCase {

    private final IUserPort userPort;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final IRolePort rolePort;
    private final AuthenticationManager authenticationManager;

    public LoginResponse login(LoginRequest request) {

        var existedUser = userPort.getUserByEmail(request.getEmail());

        if (existedUser == null || !passwordEncoder.matches(request.getPassword(), existedUser.getPassword())) {
            throw new LoginException();
        }

        var customUserDetails = new CustomUserDetails(existedUser, userPort, rolePort);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword(), customUserDetails.getAuthorities());
        authenticationManager.authenticate(authenticationToken);
        var role = rolePort.getRoleById(existedUser.getRoleId());
        return new LoginResponse(existedUser.getEmail(), existedUser.getFirstName(), existedUser.getLastName(),
                jwtTokenUtil.generateToken(existedUser), role.getCode());
    }
}
