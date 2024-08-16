package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class BadRequestException extends ApplicationException{
    public BadRequestException() {
        super(ErrorCodes.BAD_REQUEST.getMessage(), ErrorCodes.BAD_REQUEST.getCode());
    }
}
