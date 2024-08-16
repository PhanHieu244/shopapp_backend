package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class UserEmailException extends ApplicationException {
    public UserEmailException() {
        super(ErrorCodes.EMAIL_IS_EXISTED.getMessage(), ErrorCodes.EMAIL_IS_EXISTED.getCode());
    }
}
