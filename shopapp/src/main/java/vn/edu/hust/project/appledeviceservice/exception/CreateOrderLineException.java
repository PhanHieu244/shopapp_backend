package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateOrderLineException extends ApplicationException{
    public CreateOrderLineException() {
        super(ErrorCodes.CREATE_ORDER_LINE_FAIL.getMessage(), ErrorCodes.CREATE_ORDER_LINE_FAIL.getCode());
    }
}
