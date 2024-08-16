package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.OrderLineEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.port.IOrderLinePort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetOrderLineUseCase {
    private final IOrderLinePort orderLinePort;

    private final GetProductDetailUseCase getProductDetailUseCase;
    public List<OrderLineEntity> getOrderLineByOrderIds(List<Long> orderIds) {
        return orderLinePort.getOrderLineByOrderIds(orderIds);
    }

    public List<OrderLineEntity> getOrderLineByOrderId(Long orderId) {

        var orderLines = orderLinePort.getOrderLineByOrderIds(List.of(orderId));
        var productDetailIds = orderLines.stream().map(OrderLineEntity::getProductDetailId).toList();
        var productDetails = getProductDetailUseCase.getProductDetailByIds(productDetailIds);
        var mapProductDetail = productDetails.stream()
                .collect(Collectors.toMap(ProductDetailEntity::getId, Function.identity()));
        return orderLines.stream().peek(orderLine -> {
            var productDetail = mapProductDetail.getOrDefault(orderLine.getProductDetailId(), null);
            orderLine.setProductDetail(productDetail);
        }).toList();
    }
}
