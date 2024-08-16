package vn.edu.hust.project.appledeviceservice.utils;

import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;

import java.util.ArrayList;
import java.util.List;

public class ImageUtils {
    public static ArrayList<ImageEntity> saveImages(List<String> imageRequests, ImageTypeEnum imageType, Long entityID, IImagePort imagePort) {
        var images = imageRequests.stream().map(
                image -> {
                    var imageEntity = new ImageEntity();
                    imageEntity.setEntityId(entityID);
                    imageEntity.setType(imageType.name());
                    imageEntity.setImg(image);
                    return imageEntity;
                }
        ).toList();
        return (ArrayList<ImageEntity>) imagePort.saveImages(images);
    }
}
