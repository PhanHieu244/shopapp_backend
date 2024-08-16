package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class RedisConnectException extends ApplicationException{
    public RedisConnectException() {
        super(ErrorCodes.REDIS_CONNECTION_FAIL.getMessage(), ErrorCodes.REDIS_CONNECTION_FAIL.getCode());
    }
}
