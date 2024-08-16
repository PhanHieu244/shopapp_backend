package vn.edu.hust.project.appledeviceservice.service;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserWebRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.LoginRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.LoginResponse;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.SignUpResponse;

import java.util.List;

public interface IUserService {
    SignUpResponse sigUpOps(CreateUserRequest request);

    LoginResponse loginOps(LoginRequest request);

    LoginResponse loginWeb(LoginRequest request);

    SignUpResponse signUpWeb(CreateUserWebRequest request);

    Pair<PageInfo, List<UserEntity>> getAllUsers(GetUserRequest filter);

    UserEntity updateRole(Long userId, String role);


}
