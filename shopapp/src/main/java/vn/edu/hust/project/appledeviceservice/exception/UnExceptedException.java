package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class UnExceptedException extends ApplicationException{
    public UnExceptedException() {
        super(ErrorCodes.UNEXPECTED_ERROR.getMessage(), ErrorCodes.UNEXPECTED_ERROR.getCode());
    }
}
