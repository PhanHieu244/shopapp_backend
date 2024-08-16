package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class LoginException extends ApplicationException {

    public LoginException() {
        super(ErrorCodes.INVALID_EMAIL_OR_PASSWORD.getMessage(),
            ErrorCodes.INVALID_EMAIL_OR_PASSWORD.getCode());
    }
}
