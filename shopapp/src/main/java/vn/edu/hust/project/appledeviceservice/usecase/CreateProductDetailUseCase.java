package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ImageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.mapper.ProductDetailResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.utils.ImageUtils;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class CreateProductDetailUseCase {
    private final IProductDetailPort productDetailPort;

    private final IImagePort imagePort;

    @Transactional(rollbackFor = Exception.class)
    public ProductDetailEntity createProductDetail(CreateProductDetailRequest request) {

        var productDetail = ProductDetailResourceMapper.INSTANCE.toEntityFromRequest(request);

        productDetail = productDetailPort.save(productDetail);

        final var productDetailID = productDetail.getId();

        ArrayList<ImageEntity> productDetailImages = null;
        if (!CollectionUtils.isEmpty(request.getImages())) {
            productDetailImages = ImageUtils.saveImages(request.getImages(),
                    ImageTypeEnum.PRODUCT_DETAIL_IMAGE, productDetailID, imagePort);
        }

        productDetail.setImages(productDetailImages);

        return productDetail;
    }
}
