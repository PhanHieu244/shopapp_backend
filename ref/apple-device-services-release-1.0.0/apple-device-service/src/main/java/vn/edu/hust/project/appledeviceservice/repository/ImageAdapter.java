package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.IImageRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.ImageModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageAdapter implements IImagePort {

    private final IImageRepository imageRepository;

    @Override
    public ImageEntity saveImage(ImageEntity entity) {

        return ImageModelMapper.INSTANCE.toEntity(
                imageRepository.save(ImageModelMapper.INSTANCE.toModel(entity))
        );
    }


    @Override
    public List<ImageEntity> saveImages(List<ImageEntity> entities) {

        return ImageModelMapper.INSTANCE.toEntities(
                imageRepository.saveAll(ImageModelMapper.INSTANCE.toModels(entities))
        );
    }

    @Override
    public List<ImageEntity> getImagesByEntityIdAndType(Long entityId, String type) {
        return ImageModelMapper.INSTANCE.toEntities(
                imageRepository.findByEntityIdAndType(entityId, type)
        );
    }
}
