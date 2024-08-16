package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;

import java.util.List;

public interface IImagePort {
    ImageEntity saveImage(ImageEntity entity);

    List<ImageEntity> saveImages(List<ImageEntity> entities);

    List<ImageEntity> getImagesByEntityIdAndType(Long entityId, String type);
}
