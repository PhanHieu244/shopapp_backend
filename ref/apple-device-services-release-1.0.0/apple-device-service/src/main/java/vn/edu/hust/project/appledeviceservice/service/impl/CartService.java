package vn.edu.hust.project.appledeviceservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateCartRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.CartResponse;
import vn.edu.hust.project.appledeviceservice.exception.CreateCartException;
import vn.edu.hust.project.appledeviceservice.exception.UpdateCartException;
import vn.edu.hust.project.appledeviceservice.port.IInventoryPort;
import vn.edu.hust.project.appledeviceservice.service.ICartService;
import vn.edu.hust.project.appledeviceservice.usecase.CreateCartUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.DeleteCartUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.GetCartUseCase;
import vn.edu.hust.project.appledeviceservice.usecase.UpdateCartUseCase;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService implements ICartService {
    private final CreateCartUseCase createCartUseCase;

    private final GetCartUseCase getCartUseCase;

    private final UpdateCartUseCase updateCartUseCase;

    private final DeleteCartUseCase deleteCartUseCase;

    private final IInventoryPort inventoryPort;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CartEntity createCart(CreateCartRequest request, Long userId) {
        if(validateQuantity(request.getQuantity(), request.getProductDetailId())) {
            throw new CreateCartException();
        }
        return createCartUseCase.createCart(request, userId);
    }

    @Override
    public CartResponse getCartByUserId(Long userId) {

        var carts =  getCartUseCase.getCartByUserId(userId);
        var total = carts.stream().mapToLong(CartEntity::getQuantity).sum();
        var totalPrice = carts.stream().mapToLong(cart -> {
            if(cart.getProductDetail() != null) {
                return cart.getProductDetail().getPrice() * cart.getQuantity();
            }
            return 0;

        }).sum();
        return new CartResponse(total, carts, totalPrice);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CartEntity updateCart(UpdateCartRequest request, Long userId, Long cartId){
        if(validateQuantity(request.getNewQuantity(), request.getProductDetailId())) {
            throw new UpdateCartException();
        }
        return updateCartUseCase.updateCart(request, userId, cartId);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteCart(Long id, Long userId){
        deleteCartUseCase.deleteCart(id, userId);
    }

    private boolean validateQuantity(Long quantity, Long productDetailId) {
        var inventory = inventoryPort.getInventoryByProductDetailId(productDetailId);
        if(ObjectUtils.isEmpty(inventory)) {
            return true;
        }
        return quantity <= 0 || quantity > inventory.getAvailable();
    }
}
