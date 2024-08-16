package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateCartException extends ApplicationException{
    public CreateCartException() {
        super(ErrorCodes.CREATE_CART_FAIL.getMessage(), ErrorCodes.CREATE_CART_FAIL.getCode());
    }
}
