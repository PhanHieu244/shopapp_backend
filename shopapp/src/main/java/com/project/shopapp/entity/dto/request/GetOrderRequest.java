package com.project.shopapp.entity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetOrderRequest extends BaseGetRequest {
    private Long userId;
    private String state;
    private LocalDateTime orderDateFrom;
    private LocalDateTime orderDateTo;
}
