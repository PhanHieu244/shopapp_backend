package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.ProductDetailEntity;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetCartUseCase {

    private final GetProductDetailUseCase getProductDetailUseCase;
    private final ICartPort cartPort;

    public List<CartEntity> getCartByUserId(Long userId) {
        var carts = cartPort.getCartByUserId(userId);
        if (CollectionUtils.isEmpty(carts)) {
            return List.of();
        }

        carts = carts.stream().filter(cart -> cart.getQuantity() > 0).toList();

        var productDetailIds = carts.stream()
                .map(CartEntity::getProductDetailId)
                .toList();
        var productDetails = getProductDetailUseCase.getProductDetailByIds(productDetailIds);
        var mapProductDetails = productDetails.stream()
                .collect(Collectors.toMap(ProductDetailEntity::getId, Function.identity()));

        return carts.stream().peek(
                cart -> {
                    var productDetail = mapProductDetails.get(cart.getProductDetailId());
                    if (productDetail != null) {
                        cart.setProductDetail(productDetail);
                    }
                }
        ).toList();
    }

    public List<CartEntity> getCartsByIds(List<Long> cartIds) {
        return cartPort.getCartByIds(cartIds);
    }
}
