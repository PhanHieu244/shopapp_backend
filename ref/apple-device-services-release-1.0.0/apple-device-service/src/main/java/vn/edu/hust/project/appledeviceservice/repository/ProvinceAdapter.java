package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ProvinceEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateProvinceException;
import vn.edu.hust.project.appledeviceservice.port.IProvincePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IProvinceRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ProvinceModelMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProvinceAdapter implements IProvincePort {
    private final IProvinceRepository provinceRepository;
    @Override
    public ProvinceEntity getProvinceByCode(String code) {
        return ProvinceModelMapper.INSTANCE.toEntity(provinceRepository.findByCode(code).orElse(null));
    }

    @Override
    public ProvinceEntity save(ProvinceEntity provinceEntity) {
          try {
              return ProvinceModelMapper.INSTANCE
                      .toEntity(provinceRepository.save(ProvinceModelMapper.INSTANCE.toModel(provinceEntity)));
          } catch (Exception e) {
              log.error("[ProvinceAdapter][save] error: " + e.getMessage());
              throw new CreateProvinceException();
          }
    }
}
