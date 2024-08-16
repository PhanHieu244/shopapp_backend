package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class RemoveStorageException extends ApplicationException{
    public RemoveStorageException() {
        super(ErrorCodes.REMOVE_STORAGE_FAIL.getMessage(), ErrorCodes.REMOVE_STORAGE_FAIL.getCode());
    }
}
