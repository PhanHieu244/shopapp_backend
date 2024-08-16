package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.RoleEntity;

public interface IRolePort {
    RoleEntity getRoleById(Long id);

    RoleEntity getRoleByCode(String code);
}
