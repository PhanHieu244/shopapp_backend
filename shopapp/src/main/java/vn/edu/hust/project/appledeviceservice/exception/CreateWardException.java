package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateWardException extends ApplicationException{
    public CreateWardException(){
        super(ErrorCodes.CREATE_WARD_FAIL.getMessage(), ErrorCodes.CREATE_WARD_FAIL.getCode());
    }
}
