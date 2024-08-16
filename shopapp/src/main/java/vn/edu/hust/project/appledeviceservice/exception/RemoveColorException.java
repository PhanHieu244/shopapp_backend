package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class RemoveColorException extends ApplicationException{

    public RemoveColorException() {
        super(ErrorCodes.REMOVE_COLOR_FAIL.getMessage(), ErrorCodes.REMOVE_COLOR_FAIL.getCode());
    }
}
