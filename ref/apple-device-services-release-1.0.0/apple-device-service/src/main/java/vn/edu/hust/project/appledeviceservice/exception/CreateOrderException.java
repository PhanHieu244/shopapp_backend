package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateOrderException extends ApplicationException{
    public CreateOrderException() {
        super(ErrorCodes.CREATE_ORDER_FAIL.getMessage(), ErrorCodes.CREATE_ORDER_FAIL.getCode());
    }
}
