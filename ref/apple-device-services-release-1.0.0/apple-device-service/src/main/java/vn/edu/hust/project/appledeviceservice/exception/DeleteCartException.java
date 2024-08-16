package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class DeleteCartException extends ApplicationException {
    public DeleteCartException() {
        super(ErrorCodes.DELETE_CART_FAIL.getMessage(), ErrorCodes.DELETE_CART_FAIL.getCode());
    }
}
