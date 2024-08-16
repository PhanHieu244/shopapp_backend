package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetProductException extends ApplicationException{
    public GetProductException() {
        super(ErrorCodes.GET_PRODUCT_NOT_FOUND.getMessage(), ErrorCodes.GET_PRODUCT_NOT_FOUND.getCode());
    }
}
