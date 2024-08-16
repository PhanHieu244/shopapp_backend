package vn.edu.hust.project.appledeviceservice.service;

import vn.edu.hust.project.appledeviceservice.enitity.CartEntity;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.CreateCartRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.request.UpdateCartRequest;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.CartResponse;

import java.util.List;

public interface ICartService {
    CartEntity createCart(CreateCartRequest request, Long userId);

    CartResponse getCartByUserId(Long userId);

    CartEntity updateCart(UpdateCartRequest request, Long userId, Long cartId);

    void deleteCart(Long id, Long userId);
}
