package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.RoleEntity;
import vn.edu.hust.project.appledeviceservice.exception.GetRoleException;
import vn.edu.hust.project.appledeviceservice.port.IRolePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IRoleRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.RoleModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleAdapter implements IRolePort {

    private final IRoleRepository roleRepository;

    @Override
    public RoleEntity getRoleById(Long id) {
        return RoleModelMapper.INSTANCE.toRoleEntity(
                roleRepository.findById(id).orElseThrow(
                        () -> {
                            log.error("[RoleAdapter] Can not find role by id: " + id);
                            return new GetRoleException();
                        }
                )
        );
    }

    @Override
    public RoleEntity getRoleByCode(String code) {
        return RoleModelMapper.INSTANCE.toRoleEntity(
                roleRepository.findByCode(code).orElseThrow(
                        () -> {
                            log.error("[RoleAdapter] Can not find role by code : " + code);
                            return new GetRoleException();
                        }
                )
        );
    }
}
