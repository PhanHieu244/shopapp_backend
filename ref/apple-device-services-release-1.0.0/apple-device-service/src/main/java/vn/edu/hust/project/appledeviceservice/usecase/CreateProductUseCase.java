package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.mapper.ProductResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;
import vn.edu.hust.project.appledeviceservice.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase {
    private final IProductPort productPort;

    private final IImagePort imagePort;

    @Transactional(rollbackFor = Exception.class)
    public ProductEntity createProduct(CreateProductRequest request){

        var product = ProductResourceMapper.INSTANCE.toProductEntityFromRequest(request);
        product = productPort.save(product);

        final var productID = product.getId();

        ArrayList<ImageEntity> productImages = null;
        if (!CollectionUtils.isEmpty(request.getImages())){
            productImages = ImageUtils.saveImages(request.getImages(), ImageTypeEnum.PRODUCT_IMAGE, productID, imagePort);
        }

        ArrayList<ImageEntity> productDescriptionImages = null;
        if(!CollectionUtils.isEmpty(request.getDescriptionImages())){
            productDescriptionImages = ImageUtils.saveImages(request.getDescriptionImages(),
                    ImageTypeEnum.PRODUCT_DESCRIPTION_IMAGE, productID, imagePort);
        }

        product.setImages(productImages);
        product.setDescriptionImages(productDescriptionImages);

        return product;
    }

}
