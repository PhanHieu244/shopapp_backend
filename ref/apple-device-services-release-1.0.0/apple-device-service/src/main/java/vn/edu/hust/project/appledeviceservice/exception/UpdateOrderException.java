package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class UpdateOrderException extends ApplicationException {
    public UpdateOrderException() {
        super(ErrorCodes.UPDATE_ORDER_FAIL.getMessage(), ErrorCodes.UPDATE_ORDER_FAIL.getCode())   ;
    }
}
