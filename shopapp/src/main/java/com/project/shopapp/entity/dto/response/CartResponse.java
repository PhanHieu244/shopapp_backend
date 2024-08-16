package com.project.shopapp.entity.dto.response;

import com.project.shopapp.entity.CartEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartResponse {
    private Long total;
    private List<CartEntity> carts;
    private Long totalPrice;
}
