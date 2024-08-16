package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.ImageTypeEnum;
import vn.edu.hust.project.appledeviceservice.enitity.ColorEntity;
import vn.edu.hust.project.appledeviceservice.enitity.InventoryEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.StorageEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetProductDetailRequestWeb;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.PageInfo;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.ProductDetailWebResponse;
import vn.edu.hust.project.appledeviceservice.exception.GetProductDetailException;
import vn.edu.hust.project.appledeviceservice.mapper.ProductDetailResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.IColorPort;
import vn.edu.hust.project.appledeviceservice.port.IImagePort;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;
import vn.edu.hust.project.appledeviceservice.port.IProductPort;
import vn.edu.hust.project.appledeviceservice.port.IStoragePort;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class GetListProductDetailWebUseCase {
    private final IProductPort productPort;
    private final IProductDetailPort productDetailPort;
    private final IImagePort imagePort;
    private final IInventoryPort inventoryPort;
    private final IColorPort colorPort;
    private final IStoragePort storagePort;

    public Pair<PageInfo, List<ProductDetailEntity>> getAllProductDetailsWeb(
            GetProductDetailRequestWeb filter
    ) {
        return productDetailPort.getAllProductDetailsWeb(filter);
    }

    public ProductDetailWebResponse getProductDetailWebById(Long id) {
        try {
            var productDetail = productDetailPort.getProductDetail(id);
            var productDetailImages = imagePort.getImagesByEntityIdAndType(productDetail.getId(),
                    ImageTypeEnum.PRODUCT_DESCRIPTION_IMAGE.name());
            productDetail.setImages(productDetailImages);

            var productDetailWebResponse = ProductDetailResourceMapper.INSTANCE
                    .toWebResponse(productDetail);

            var product = productPort.getProductById(productDetail.getProductId());
            productDetailWebResponse.setProduct(product);

            var productDetails = getProductDetailEntitiesByProductId(product.getId());


            makeRelatedColorResponse(productDetail, productDetailWebResponse, productDetails);


            makeRelatedStorageResponse(productDetails, productDetailWebResponse);

            return productDetailWebResponse;
        } catch (Exception e) {
            log.error("[GetListProductDetailWebUseCase] getProductDetailWebById error: {}", e.getMessage());
            throw new GetProductDetailException();
        }
    }

    private static void makeRelatedStorageResponse(List<ProductDetailEntity> productDetails, ProductDetailWebResponse productDetailWebResponse) {
        List<ProductDetailEntity> maxProductDetailsByStorageId = productDetails.stream()
                .collect(Collectors.groupingBy(
                        ProductDetailEntity::getStorageId,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(pd -> Math.toIntExact(pd.getInventory().getAvailable()))),
                                Optional::get
                        )
                )).values().stream().toList();
        var relatedStorageWebResponse = ProductDetailResourceMapper
                .INSTANCE.toRelatedStorageWebResponseList(maxProductDetailsByStorageId);
        productDetailWebResponse.setRelatedStorages(relatedStorageWebResponse);
    }

    private List<ProductDetailEntity> getProductDetailEntitiesByProductId(Long productId) {
        var productDetails = productDetailPort.getProductDetailsByProductId(productId);
        var productDetailIds = productDetails.stream()
                .map(ProductDetailEntity::getId)
                .toList();

        var inventories = inventoryPort.getInventoryByProductDetailIds(productDetailIds);
        var inventoryMap = inventories.stream()
                .collect(Collectors.toMap(InventoryEntity::getProductDetailId, Function.identity()));
        productDetails = productDetails.stream()
                .peek(productDetailEntity -> {
                    var inventory = inventoryMap.getOrDefault(productDetailEntity.getId(), null);
                    productDetailEntity.setInventory(inventory);
                }).toList();

        var colorIds = productDetails.stream()
                .map(ProductDetailEntity::getColorId)
                .toList();
        var colors = colorPort.findByIds(colorIds);
        var colorsMap = colors.stream()
                .collect(Collectors.toMap(ColorEntity::getId, Function.identity()));
        productDetails = productDetails.stream().peek(
                productDetailEntity -> {
                    var color = colorsMap.getOrDefault(productDetailEntity.getColorId(), null);
                    productDetailEntity.setColor(color);
                }
        ).toList();

        var storageIds = productDetails.stream()
                .map(ProductDetailEntity::getStorageId)
                .toList();
        var storages = storagePort.findByIds(storageIds);
        var storagesMap = storages.stream()
                .collect(Collectors.toMap(StorageEntity::getId, Function.identity()));
        productDetails = productDetails.stream().peek(
                productDetailEntity -> {
                    var storage = storagesMap.getOrDefault(productDetailEntity.getStorageId(), null);
                    productDetailEntity.setStorage(storage);
                }
        ).toList();

        return productDetails;
    }

    private void makeRelatedColorResponse(ProductDetailEntity productDetail, ProductDetailWebResponse productDetailWebResponse,
                                          List<ProductDetailEntity> productDetails) {
        var relatedProductDetailsByColors = productDetails.stream()
                .filter(productDetailEntity -> productDetailEntity.getStorageId().equals(productDetail.getStorageId()))
                .toList();

        if (!CollectionUtils.isEmpty(relatedProductDetailsByColors)) {
            var relatedProductDetailsByColorsWeb = ProductDetailResourceMapper.INSTANCE
                    .toRelatedColorWebResponseList(relatedProductDetailsByColors);
            productDetailWebResponse.setRelatedColors(relatedProductDetailsByColorsWeb);
        }
    }
}
