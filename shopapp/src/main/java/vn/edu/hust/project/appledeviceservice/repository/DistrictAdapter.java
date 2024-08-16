package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.DistrictEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateDistrictException;
import vn.edu.hust.project.appledeviceservice.port.IDistrictPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IDistrictRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.DistrictModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class DistrictAdapter implements IDistrictPort {
    private final IDistrictRepository districtRepository;

    @Override
    public DistrictEntity getDistrictByCode(String code) {
        return DistrictModelMapper.INSTANCE.toEntity(districtRepository.findByCode(code).orElse(null));
    }

    @Override
    public DistrictEntity save(DistrictEntity districtEntity) {
        try {
            return DistrictModelMapper.INSTANCE.
                    toEntity(districtRepository.save(DistrictModelMapper.INSTANCE.toModel(districtEntity)));
        } catch (Exception e) {
            log.error("[DistrictAdapter][save] error: " + e.getMessage());
            throw new CreateDistrictException();
        }
    }
}
