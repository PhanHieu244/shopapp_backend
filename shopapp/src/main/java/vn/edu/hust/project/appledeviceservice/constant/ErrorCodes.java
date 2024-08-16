package vn.edu.hust.project.appledeviceservice.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodes {
    CREATE_COLOR_FAIL(400001L, "Create color fail"),

    CREATE_STORAGE_FAIL(400002L, "Create storage fail"),

    CREATE_TYPE_FAIL(400003L, "Create type fail"),

    CREATE_IMAGE_FAIL(400004L, "Create image fail"),

    CREATE_PRODUCT_FAIL(400005L, "Create product fail"),

    GET_TYPE_NOT_FOUND(400006L, "Get type not found"),

    GET_COLOR_NOT_FOUND(400007L, "Get color not found"),

    GET_STORAGE_NOT_FOUND(400008L, "Get storage not found"),

    CREATE_PRODUCT_DETAIL_NOT_FOUND(400009L, "Create product detail fail"),

    CREATE_INVENTORY_FAIL(4000010L, "Create inventory fail"),

    GET_PRODUCT_NOT_FOUND(4000011L, "Get product not found"),

    GET_PRODUCT_DETAIL_NOT_FOUND(4000012L, "Get product detail not found"),

    CREATE_USER_FAIL(4000013L, "Create user fail"),

    GET_USER_NOT_FOUND(4000014L, "Get user not found"),

    GET_ROLE_NOT_FOUND(4000015L, "Get role not found"),

    EMAIL_IS_EXISTED(4000016L, "Email is existed"),

    INVALID_EMAIL_OR_PASSWORD(4000017L, "Invalid email or password"),

    UNEXPECTED_ERROR(4000018L, "Unexpected error"),

    REMOVE_COLOR_FAIL(4000019L, "Remove color fail"),

    REMOVE_STORAGE_FAIL(4000020L, "Remove storage fail"),

    REMOVE_TYPE_FAIL(4000021L, "Remove type fail"),

    CREATE_CART_FAIL(4000022L, "Create cart fail"),

    BAD_REQUEST(400L, "Bad request"),

    UPDATE_CART_FAIL(4000023L, "Update cart fail"),

    GET_CART_NOT_FOUND(4000024L, "Cart not found"),

    DELETE_CART_FAIL(4000025L, "Delete cart fail"),

    CREATE_WARD_FAIL(4000026L, "Create ward fail"),

    CREATE_DISTRICT_FAIL(4000027L, "Create district fail"),

    CREATE_PROVINCE_FAIL(4000028L, "Create province fail"),

    CREATE_SHIPPING_INFO_FAIL(4000029L, "Create shipping info fail"),

    GET_SHIPPING_INFO_NOT_FOUND(4000030L, "Get shipping info not found"),

    CREATE_ORDER_FAIL(4000031L, "Create order fail"),

    CREATE_ORDER_LINE_FAIL(4000032L, "Create order line fail"),

    REDIS_CONNECTION_FAIL(4000033L, "Redis connection fail"),

    CHANGE_INVENTORY_FAIL(4000034L, "Change inventory fail"),

    NOT_ENOUGH_INVENTORY(4000035L, "Not enough inventory"),

    UPDATE_ORDER_FAIL(4000036L, "Update order fail"),

    CANCEL_ORDER_FAIL(4000037L, "Cancel order fail"),

    UPDATE_USER_FAIL(4000038L, "Update user fail"),

    CREATE_BLOG_FAIL(4000039L, "Create blog fail"),

    GET_BLOG_NOT_FOUND(4000040L, "Get blog not found"),

    GET_ORDER_NOT_FOUND(4000041L, "Get order not found"),

    GET_WARRANTY_NOT_FOUND(4000042L, "Get warranty not found"),

    GET_STATISTIC_FAIL(4000043L, "Get statistic fail"),
    ;

    private final Long code;
    private final String message;

}
