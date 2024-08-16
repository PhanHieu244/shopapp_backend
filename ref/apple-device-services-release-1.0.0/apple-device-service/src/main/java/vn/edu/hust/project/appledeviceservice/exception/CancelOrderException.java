package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CancelOrderException extends ApplicationException {
    public CancelOrderException() {
        super(ErrorCodes.CANCEL_ORDER_FAIL.getMessage(), ErrorCodes.CANCEL_ORDER_FAIL.getCode());
    }
}
