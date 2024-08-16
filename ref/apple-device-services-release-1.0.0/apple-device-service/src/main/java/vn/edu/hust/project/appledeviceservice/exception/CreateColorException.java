package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateColorException extends ApplicationException{
    public CreateColorException() {
        super(ErrorCodes.CREATE_COLOR_FAIL.getMessage(), ErrorCodes.CREATE_COLOR_FAIL.getCode());
    }
}
