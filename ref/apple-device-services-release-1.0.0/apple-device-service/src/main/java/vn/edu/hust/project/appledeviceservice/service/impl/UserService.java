package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.LoginResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.SignUpResponse;
import vn.edu.hust.project.appledeviceservice.service.IUserService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateUserUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetUserUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.SignInUserUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.UpdateUserUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final CreateUserUseCase createUserUseCase;

    private final SignInUserUseCase signInUserUseCase;

    private final GetUserUseCase getUserUseCase;

    private final UpdateUserUseCase updateUserUseCase;
    @Override
    public SignUpResponse sigUpOps(CreateUserRequest request) {
        return createUserUseCase.createUser(request);
    }

    @Override
    public LoginResponse loginOps(LoginRequest request) {
        return signInUserUseCase.login(request);
    }

    @Override
    public LoginResponse loginWeb(LoginRequest request) {
        return signInUserUseCase.login(request);
    }

    @Override
    public SignUpResponse signUpWeb(CreateUserWebRequest request) {
        return createUserUseCase.createUserWeb(request);
    }

    @Override
    public Pair<PageInfo, List<UserEntity>> getAllUsers(GetUserRequest filter) {
        return getUserUseCase.getAllUsers(filter);
    }

    @Override
    public UserEntity updateRole(Long userId, String role) {
        return updateUserUseCase.updateUserRole(userId, role);
    }

}
