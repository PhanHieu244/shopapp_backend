package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class UpdateUserException extends ApplicationException {
    public UpdateUserException() {
        super(ErrorCodes.UPDATE_USER_FAIL.getMessage(), ErrorCodes.UPDATE_USER_FAIL.getCode());
    }
}
