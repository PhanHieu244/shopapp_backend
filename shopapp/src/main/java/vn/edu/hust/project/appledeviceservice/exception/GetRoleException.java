package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetRoleException extends ApplicationException {
    public GetRoleException() {
        super(ErrorCodes.GET_ROLE_NOT_FOUND.getMessage(), ErrorCodes.GET_ROLE_NOT_FOUND.getCode());
    }
}
