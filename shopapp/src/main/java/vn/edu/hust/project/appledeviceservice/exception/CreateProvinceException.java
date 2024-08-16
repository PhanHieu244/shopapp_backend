package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateProvinceException extends ApplicationException {
    public CreateProvinceException() {
        super(ErrorCodes.CREATE_PROVINCE_FAIL.getMessage(), ErrorCodes.CREATE_PROVINCE_FAIL.getCode());
    }
}
