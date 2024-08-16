package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.enitity.UserEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetUserRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.port.IUserPort;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetUserUseCase {
    private final IRolePort rolePort;
    private final IUserPort userPort;

    public Pair<PageInfo, List<UserEntity>> getAllUsers(GetUserRequest filter) {
        var role = rolePort.getRoleByCode(filter.getRole());
        filter.setRoleId(role.getId());
        var result = userPort.getAllUsers(filter);
        if(CollectionUtils.isEmpty(result.getSecond())) {
            return result;
        }
        var users = result.getSecond();
        users = users.stream().peek(u ->{
            u.setRole(role.getCode());
            u.setPassword(null);
            u.setRoleId(null);
                }

        ).toList();
        return Pair.of(result.getFirst(), users);

    }
}
