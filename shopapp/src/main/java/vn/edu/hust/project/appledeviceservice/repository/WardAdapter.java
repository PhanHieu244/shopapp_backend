package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.WardEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateWardException;
import vn.edu.hust.project.appledeviceservice.port.IWardPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IWardRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.WardModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class WardAdapter implements IWardPort {
    private final IWardRepository wardRepository;

    @Override
    public WardEntity getWardByCode(String code) {
        return WardModelMapper.INSTANCE.toEntity(wardRepository.findByCode(code).orElse(null));
    }

    @Override
    public WardEntity save(WardEntity wardEntity) {
        try
        {
            return WardModelMapper.INSTANCE.toEntity(wardRepository.save(WardModelMapper.INSTANCE.toModel(wardEntity)));
        }
        catch (Exception e)
        {
            log.error("[WardAdapter][save] error: " + e.getMessage());
            throw new CreateWardException();
        }

    }
}
