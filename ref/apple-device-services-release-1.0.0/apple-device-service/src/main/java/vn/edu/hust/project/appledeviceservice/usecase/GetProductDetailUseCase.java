package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductEntity;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetProductDetailUseCase {
    private final IProductDetailPort productDetailPort;

    private final IImagePort imagePort;

    private final IColorPort colorPort;

    private final IStoragePort storagePort;

    private final IInventoryPort inventoryPort;

    private final GetProductUseCase getProductUseCase;

    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetails(
            GetProductDetailRequest filter
    ) {
        return productDetailPort.getAllProductDetails(filter);
    }

    public ProductDetailEntity getProductDetail(Long id) {
        var productDetail = productDetailPort.getProductDetail(id);

        var images = imagePort.getImagesByEntityIdAndType(
                productDetail.getId(), ImageTypeEnum.PRODUCT_DETAIL_IMAGE.name()
        );

        var color = colorPort.getColorById(productDetail.getColorId());
        var storage = storagePort.getStorageById(productDetail.getStorageId());

        productDetail.setColor(color);
        productDetail.setStorage(storage);
        productDetail.setImages(images);

        return productDetail;
    }

    public List<ProductDetailEntity> getProductDetailByIds(List<Long> ids) {
        var productDetails = productDetailPort.getProductDetailByIds(ids);
        if (CollectionUtils.isEmpty(productDetails)) {
            return List.of();
        }
        var productIds = productDetails.stream().map(ProductDetailEntity::getProductId).toList();
        var products = getProductUseCase.getProductByIds(productIds);
        var productMap =
                products.stream().collect(Collectors.toMap(ProductEntity::getId, Function.identity()));
        var colorIds = productDetails.stream().map(ProductDetailEntity::getColorId).toList();
        if (CollectionUtils.isEmpty(colorIds)) {
            return List.of();
        }
        var colors = colorPort.findByIds(colorIds);
        var colorMap =
                colors.stream().collect(Collectors.toMap(ColorEntity::getId, Function.identity()));

        var storageIds = productDetails.stream().map(ProductDetailEntity::getStorageId).toList();
        if (CollectionUtils.isEmpty(storageIds)) {
            return List.of();
        }
        var storages = storagePort.findByIds(storageIds);
        var storageMap = storages.stream().collect(Collectors.toMap(StorageEntity::getId, Function.identity()));

        var inventories = inventoryPort.getInventoryByProductDetailIds(ids);
        var inventoryMap = inventories.stream().collect(Collectors.toMap(InventoryEntity::getProductDetailId, Function.identity()));

        return productDetails.stream().peek(
                productDetail -> {
                    var product = productMap.get(productDetail.getProductId());
                    if (product != null) {
                        productDetail.setProduct(product);
                    }
                    var color = colorMap.get(productDetail.getColorId());
                    if (color != null) {
                        productDetail.setColor(color);
                    }

                    var storage = storageMap.get(productDetail.getStorageId());
                    if (storage != null) {
                        productDetail.setStorage(storage);
                    }

                    var inventory = inventoryMap.get(productDetail.getId());
                    if (inventory != null) {
                        inventory.setAmount(null);
                        inventory.setSold(null);
                        productDetail.setInventory(inventory);
                    }

                }
        ).collect(Collectors.toList());

    }
}
