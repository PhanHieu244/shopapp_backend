package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.WarrantyStatusEnum;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.enitity.WarrantyEntity;
import vn.edu.hust.project.appledeviceservice.exception.GetWarrantyException;
import vn.edu.hust.project.appledeviceservice.utils.TimeUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetWarrantyInfoUseCase {
    private final GetOrderUseCase getOrderUseCase;

    private final GetOrderLineUseCase getOrderLineUseCase;

    private final GetProductDetailUseCase getProductDetailUseCase;

    public List<WarrantyEntity> getWarrantyInfo(String orderCode) {
        try {
            var order = getOrderUseCase.getOrderByCode(orderCode);
            var orderLines = getOrderLineUseCase.getOrderLineByOrderId(order.getId());

            var productDetailIds = orderLines.stream().map(OrderLineEntity::getProductDetailId).toList();
            var productDetails = getProductDetailUseCase.getProductDetailByIds(productDetailIds);
            if (CollectionUtils.isEmpty(productDetails)) {
                throw new GetWarrantyException();
            }

            return orderLines.stream().map(orderLine -> {
                var productDetail = productDetails.stream()
                        .filter(productDetailEntity -> productDetailEntity.getId().equals(orderLine.getProductDetailId()))
                        .findFirst()
                        .orElse(null);
                if (productDetail == null) {
                    return null;
                }
                var warrantyDuration = productDetail.getProduct().getWarrantyDuration();
                var warrantyDateTo =
                        TimeUtils.convertUnixTimeToLocalDateTime(order.getCreatedAt()).plusMonths(warrantyDuration);

                return WarrantyEntity.builder()
                        .productDetail(productDetail)
                        .warrantyDateTo(TimeUtils.convertLocalDateTimeToUnixTime(warrantyDateTo))
                        .warrantyDuration(warrantyDuration)
                        .warrantyStatus(LocalDateTime.now().isBefore(warrantyDateTo) ? WarrantyStatusEnum.ACTIVE.name()
                                : WarrantyStatusEnum.EXPIRED.name())
                        .orderCode(orderCode)
                        .build();
            }).toList();

        } catch (Exception e) {
            log.error("[GetWarrantyInfoUseCase] Error when get warranty info", e);
            throw new GetWarrantyException();
        }
    }
}
