package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetColorException extends ApplicationException {
    public GetColorException() {
        super(ErrorCodes.GET_COLOR_NOT_FOUND.getMessage(), ErrorCodes.GET_COLOR_NOT_FOUND.getCode());
    }
}
