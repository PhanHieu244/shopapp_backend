package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetShippingInfoException extends ApplicationException{
    public GetShippingInfoException(){
        super(ErrorCodes.GET_SHIPPING_INFO_NOT_FOUND.getMessage(), ErrorCodes.GET_SHIPPING_INFO_NOT_FOUND.getCode());
    }
}
