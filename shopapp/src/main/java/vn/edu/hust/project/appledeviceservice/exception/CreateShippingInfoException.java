package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateShippingInfoException extends ApplicationException{
    public CreateShippingInfoException(){
        super(ErrorCodes.CREATE_SHIPPING_INFO_FAIL.getMessage(), ErrorCodes.CREATE_SHIPPING_INFO_FAIL.getCode());
    }
}
