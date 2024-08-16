package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetUserException extends ApplicationException{
    public GetUserException() {
        super(ErrorCodes.GET_USER_NOT_FOUND.getMessage(), ErrorCodes.GET_TYPE_NOT_FOUND.getCode());
    }
}
