package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateTypeException extends ApplicationException{
    public CreateTypeException() {
        super(ErrorCodes.CREATE_TYPE_FAIL.getMessage(), ErrorCodes.CREATE_TYPE_FAIL.getCode());
    }
}
