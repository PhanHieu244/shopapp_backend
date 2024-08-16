package com.project.shopapp.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    LOGIN_ERROR(4000001, "Login Error"),
    ;

    private final long code;
    private final String message;
}
