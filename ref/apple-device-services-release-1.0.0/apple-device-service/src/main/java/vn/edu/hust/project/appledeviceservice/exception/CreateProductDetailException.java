package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateProductDetailException extends ApplicationException {
    public CreateProductDetailException() {
        super(ErrorCodes.CREATE_PRODUCT_DETAIL_NOT_FOUND.getMessage(), ErrorCodes.CREATE_PRODUCT_DETAIL_NOT_FOUND.getCode());
    }
}
