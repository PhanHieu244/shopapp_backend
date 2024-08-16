package vn.edu.hust.project.appledeviceservice.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.mapper.CartResourceMapper;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;

@Service
@RequiredArgsConstructor
public class CreateCartUseCase {
    private final ICartPort cartPort;

    public CartEntity createCart(CreateCartRequest request, Long userId) {
        var existedCart = cartPort.getCartByUserIdAndProductDetailId(userId, request.getProductDetailId());
        if (!ObjectUtils.isEmpty(existedCart)) {
            return updateCart(existedCart, request);
        }
        var cartEntity = CartResourceMapper.INSTANCE.toEntityFromRequest(request);
        cartEntity.setUserId(userId);
        return cartPort.save(cartEntity);
    }

    private CartEntity updateCart(CartEntity cartEntity, CreateCartRequest request) {
        cartEntity.setQuantity(cartEntity.getQuantity() + request.getQuantity());
        return cartPort.save(cartEntity);
    }
}
