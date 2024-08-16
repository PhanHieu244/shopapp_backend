package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateUserException extends ApplicationException{
    public CreateUserException() {
        super(ErrorCodes.CREATE_USER_FAIL.getMessage(), ErrorCodes.CREATE_USER_FAIL.getCode());
    }
}
