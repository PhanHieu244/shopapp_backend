package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateProductException extends ApplicationException {
    public CreateProductException() {
        super(ErrorCodes.CREATE_PRODUCT_FAIL.getMessage(), ErrorCodes.CREATE_PRODUCT_FAIL.getCode());
    }
}
