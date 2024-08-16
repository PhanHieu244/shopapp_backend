package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetTypeException extends ApplicationException{
    public GetTypeException() {
        super(ErrorCodes.GET_TYPE_NOT_FOUND.getMessage(), ErrorCodes.GET_TYPE_NOT_FOUND.getCode());
    }
}
