package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateCartRequest;
import vn.edu.hust.project.appledeviceservice.exception.UpdateCartException;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;
import vn.edu.hust.project.appledeviceservice.port.IProductDetailPort;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateCartUseCase {

    private final ICartPort cartPort;
    private final IProductDetailPort productDetailPort;

    public CartEntity updateCart(UpdateCartRequest request, Long userId, Long cartId) {
        var existedCart = cartPort.getCartByUserIdAndCartId(userId, cartId);
        if (ObjectUtils.isEmpty(existedCart)) {
            log.error("[UpdateCartUseCase] Cart not found");
            throw new UpdateCartException();
        }
        var productDetail = productDetailPort.getProductDetail(request.getProductDetailId());
        existedCart.setProductDetail(productDetail);
        existedCart.setQuantity(request.getNewQuantity());
        existedCart =  cartPort.save(existedCart);
        existedCart.setProductDetail(productDetail);
        return existedCart;
    }
}
