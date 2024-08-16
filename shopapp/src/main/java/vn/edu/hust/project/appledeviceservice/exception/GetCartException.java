package vn.edu.hust.project.appledeviceservice.exception;


import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetCartException extends ApplicationException{
    public GetCartException() {
        super(ErrorCodes.GET_CART_NOT_FOUND.getMessage(), ErrorCodes.GET_TYPE_NOT_FOUND.getCode());
    }
}
