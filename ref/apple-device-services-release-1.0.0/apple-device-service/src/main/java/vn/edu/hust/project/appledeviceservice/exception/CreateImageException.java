package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateImageException extends ApplicationException {
    public CreateImageException() {
        super(ErrorCodes.CREATE_IMAGE_FAIL.getMessage(), ErrorCodes.CREATE_IMAGE_FAIL.getCode());
    }
}
