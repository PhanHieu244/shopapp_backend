package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class UpdateCartException extends ApplicationException{
    public UpdateCartException(){
        super(ErrorCodes.UPDATE_CART_FAIL.getMessage(), ErrorCodes.UPDATE_CART_FAIL.getCode());
    }
}
