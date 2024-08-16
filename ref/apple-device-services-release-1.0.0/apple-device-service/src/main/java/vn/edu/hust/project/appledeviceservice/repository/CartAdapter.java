package vn.edu.hust.project.appledeviceservice.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.exception.CreateCartException;
import vn.edu.hust.project.appledeviceservice.exception.DeleteCartException;
import vn.edu.hust.project.appledeviceservice.exception.GetCartException;
import vn.edu.hust.project.appledeviceservice.port.ICartPort;
import vn.edu.hust.project.appledeviceservice.repository.mysql.ICartRepository;
import vn.edu.hust.project.appledeviceservice.repository.mysql.mapper.CartModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartAdapter implements ICartPort {
    private final ICartRepository cartRepository;

    @Override
    public CartEntity save(CartEntity cartEntity) {
        try {
            return CartModelMapper.INSTANCE.toEntity(cartRepository.save(
                    CartModelMapper.INSTANCE.toModel(cartEntity)
            ));
        } catch (Exception e) {
            log.error("[CartAdapter] save cart error: {}", e.getMessage());
            throw new CreateCartException();
        }
    }

    @Override
    public List<CartEntity> getCartByUserId(Long userId) {
        return CartModelMapper.INSTANCE.toEntities(
                cartRepository.findByUserId(userId)
        );
    }

    @Override
    public CartEntity getCartByUserIdAndCartId(Long userId, Long cartId) {
        return CartModelMapper.INSTANCE.toEntity(
                cartRepository.findByUserIdAndId(userId, cartId).orElse(null)
        );
    }

    @Override
    public CartEntity getCartByUserIdAndProductDetailId(Long userId, Long productDetailId) {
        return CartModelMapper.INSTANCE.toEntity(
                cartRepository.findByUserIdAndProductDetailId(userId, productDetailId).orElse(null)
        );
    }

    @Override
    public CartEntity getCartByIdAndUserId(Long id, Long userId) {
        return CartModelMapper.INSTANCE.toEntity(
                cartRepository.findByIdAndUserId(id, userId).orElseThrow(GetCartException::new)
        );
    }

    @Override
    public void deleteCart(Long id) {
        try {
            cartRepository.deleteById(id);
        } catch (Exception e) {
            log.error("[CartAdapter] delete cart error: {}", e.getMessage());
            throw new DeleteCartException();
        }

    }

    @Override
    public void deleteCartByIds(List<Long> cartIds) {
        try {
            cartRepository.deleteByIdIn(cartIds);
        } catch (Exception e) {
            log.error("[CartAdapter] delete cart error: {}", e.getMessage());
            throw new DeleteCartException();
        }
    }

    @Override
    public List<CartEntity> getCartByIds(List<Long> cartIds) {
        return CartModelMapper.INSTANCE.toEntities(
                cartRepository.findByIdIn(cartIds)
        );
    }
}
