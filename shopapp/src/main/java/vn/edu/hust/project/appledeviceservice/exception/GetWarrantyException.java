package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetWarrantyException extends ApplicationException{
    public GetWarrantyException() {
        super(ErrorCodes.GET_WARRANTY_NOT_FOUND.getMessage(), ErrorCodes.GET_WARRANTY_NOT_FOUND.getCode());
    }
}
