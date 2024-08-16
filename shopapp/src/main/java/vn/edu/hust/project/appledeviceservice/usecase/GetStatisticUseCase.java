package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.constant.OrderState;
import vn.edu.hust.project.appledeviceservice.enitity.OrderEntity;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.enitity.StatisticEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetOrderRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.GetStatRequest;
import vn.edu.hust.project.appledeviceservice.exception.GetStatisticException;
import vn.edu.hust.project.appledeviceservice.utils.TimeUtils;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetStatisticUseCase {
    private final GetOrderUseCase getOrderUseCase;
    private final GetOrderLineUseCase getOrderLineUseCase;
    private final GetProductDetailUseCase getProductDetailUseCase;

    public StatisticEntity getAllStatics(GetStatRequest filter) {
        try {
            var stats = new StatisticEntity();

            var orderFilter = new GetOrderRequest();
            orderFilter.setOrderDateFrom(TimeUtils.convertUnixTimeToLocalDateTime(filter.getOrderDateFrom()));
            orderFilter.setOrderDateTo(TimeUtils.convertUnixTimeToLocalDateTime(filter.getOrderDateTo()));

            var orders = getOrderUseCase.getAll(orderFilter);

            if (CollectionUtils.isEmpty(orders))
                return null;
            orders = orders.stream().filter(order -> !OrderState.CANCELLED.name().equalsIgnoreCase(order.getState())).toList();
            stats.setTotalOrder((long) orders.size());

            var orderIds = orders.stream().map(OrderEntity::getId).toList();
            var orderLines = getOrderLineUseCase.getOrderLineByOrderIds(orderIds);

            if (CollectionUtils.isEmpty(orderLines))
                return null;
            stats.setTotalSoldProduct((long) orderLines.size());

            var productDetailIds = orderLines.stream().map(OrderLineEntity::getProductDetailId).toList();
            var productDetails = getProductDetailUseCase.getProductDetailByIds(productDetailIds);
            var mapProductDetail = productDetails.stream()
                    .collect(Collectors.toMap(ProductDetailEntity::getId, Function.identity()));
            var totalPrice = orderLines.stream().mapToLong(orderLine -> {
                var productDetail = mapProductDetail.get(orderLine.getProductDetailId());
                return productDetail.getPrice() * orderLine.getQuantity();
            }).sum();
            stats.setTotalPrice(totalPrice);

            return stats;
        } catch (Exception e) {
            log.error("[GetStatisticUseCase] Error when get statistic", e);
            throw new GetStatisticException();
        }
    }
}
