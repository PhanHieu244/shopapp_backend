package vn.edu.hust.project.appledeviceservice.port;

import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;

import java.util.List;

public interface ICartPort {
    CartEntity save(CartEntity cartEntity);

    List<CartEntity> getCartByUserId(Long userId);

    CartEntity getCartByUserIdAndCartId(Long userId, Long cartId);

    CartEntity getCartByUserIdAndProductDetailId(Long userId, Long productDetailId);

    CartEntity getCartByIdAndUserId(Long id, Long userId);

    void deleteCart(Long id);

    void deleteCartByIds(List<Long> cartIds);

    List<CartEntity> getCartByIds(List<Long> cartIds);
}
