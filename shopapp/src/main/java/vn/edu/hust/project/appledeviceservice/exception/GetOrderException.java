package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetOrderException extends ApplicationException {
    public GetOrderException() {
        super(ErrorCodes.GET_ORDER_NOT_FOUND.getMessage(), ErrorCodes.GET_ORDER_NOT_FOUND.getCode());
    }
}
