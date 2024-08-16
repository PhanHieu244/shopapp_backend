package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetProductDetailException extends ApplicationException{
    public GetProductDetailException() {
        super(ErrorCodes.GET_PRODUCT_DETAIL_NOT_FOUND.getMessage(),
                ErrorCodes.GET_PRODUCT_DETAIL_NOT_FOUND.getCode());
    }
}
