package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetStatisticException extends ApplicationException{
    public GetStatisticException() {
        super(ErrorCodes.GET_STATISTIC_FAIL.getMessage(), ErrorCodes.GET_STATISTIC_FAIL.getCode());
    }
}
