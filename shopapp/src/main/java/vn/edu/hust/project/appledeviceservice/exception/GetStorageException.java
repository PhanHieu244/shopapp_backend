package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetStorageException extends ApplicationException{
    public GetStorageException() {
        super(ErrorCodes.GET_STORAGE_NOT_FOUND.getMessage(), ErrorCodes.GET_STORAGE_NOT_FOUND.getCode());
    }
}
