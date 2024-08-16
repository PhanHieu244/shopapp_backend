package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ShippingInfoEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateShippingInfoException;
import vn.edu.hust.project.appledeviceservice.exception.GetShippingInfoException;
import vn.edu.hust.project.appledeviceservice.port.IShippingInfoPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IShippingInfoRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ShippingInfoModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShippingInfoAdapter implements IShippingInfoPort {
    private final IShippingInfoRepository shippingInfoRepository;

    @Override
    public ShippingInfoEntity save(ShippingInfoEntity shippingInfoEntity) {
        try {
            return ShippingInfoModelMapper.INSTANCE
                    .toEntity(shippingInfoRepository.save(ShippingInfoModelMapper.INSTANCE.toModel(shippingInfoEntity)));
        } catch (Exception e) {
            log.error("[ShippingInfoAdapter][save] error: " + e.getMessage());
            throw new CreateShippingInfoException();
        }
    }

    @Override
    public ShippingInfoEntity getInfoByUserIdAndId(Long userId, Long id) {
        return ShippingInfoModelMapper.INSTANCE.toEntity(
                shippingInfoRepository.findByUserIdAndId(userId, id).orElseThrow(GetShippingInfoException::new));
    }

    @Override
    public List<ShippingInfoEntity> getInfoByIds(List<Long> ids) {
        return ShippingInfoModelMapper.INSTANCE.toEntityList(shippingInfoRepository.findByIdIn(ids));
    }

    @Override
    public ShippingInfoEntity getShippingInfoById(Long id) {
        return ShippingInfoModelMapper.INSTANCE.toEntity(
                shippingInfoRepository.findById(id).orElseThrow(GetShippingInfoException::new));
    }
}
