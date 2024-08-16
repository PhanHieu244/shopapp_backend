package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateUserUseCase {
    private final IRolePort rolePort;
    private final IUserPort userPort;

    public UserEntity updateUserRole(Long userId, String role) {
        var user = userPort.getUserById(userId);
        var roleEntity = rolePort.getRoleByCode(role);
        user.setRoleId(roleEntity.getId());
        return userPort.save(user);
    }
}
