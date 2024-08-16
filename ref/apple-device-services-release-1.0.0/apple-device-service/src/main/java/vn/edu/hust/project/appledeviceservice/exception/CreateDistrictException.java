package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateDistrictException extends ApplicationException{
    public CreateDistrictException(){
        super(ErrorCodes.CREATE_DISTRICT_FAIL.getMessage(), ErrorCodes.CREATE_DISTRICT_FAIL.getCode());
    }
}
