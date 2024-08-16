package vn.edu.hust.project.appledeviceservice.port;

import org.springframework.data.util.Pair;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;

import java.util.List;

public interface IUserPort {
    UserEntity save(UserEntity entity);

    UserEntity getUserByEmail(String email);

    Pair<PageInfo, List<UserEntity>> getAllUsers(GetUserRequest filter);

    UserEntity getUserById(Long userId);
}
