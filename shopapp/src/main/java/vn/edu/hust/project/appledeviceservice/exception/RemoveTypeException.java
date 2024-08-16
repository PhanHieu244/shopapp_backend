package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class RemoveTypeException extends ApplicationException {
    public RemoveTypeException() {
        super(ErrorCodes.REMOVE_TYPE_FAIL.getMessage(), ErrorCodes.REMOVE_TYPE_FAIL.getCode());
    }

}
