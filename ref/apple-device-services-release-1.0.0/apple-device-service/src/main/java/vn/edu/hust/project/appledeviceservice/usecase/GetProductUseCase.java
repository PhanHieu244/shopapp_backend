package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductUseCase {
    private final IProductPort productPort;

    private final IImagePort imagePort;
    public Pair<PageInfo, List<ProductEntity>> getAllProducts(GetProductRequest filter) {
        return productPort.getAllProducts(filter);
    }

    public ProductEntity getProductDetail(Long id) {
        var product = productPort.getProductById(id);
        var imageDescriptions = imagePort.getImagesByEntityIdAndType(
                product.getId(), ImageTypeEnum.PRODUCT_DESCRIPTION_IMAGE.name()
        );
        var images = imagePort.getImagesByEntityIdAndType(
                product.getId(), ImageTypeEnum.PRODUCT_IMAGE.name()
        );

        product.setDescriptionImages(imageDescriptions);
        product.setImages(images);

        return product;
    }

    public List<ProductEntity> getProductByIds(List<Long> ids) {
        return productPort.getProductByIds(ids);
    }
}
