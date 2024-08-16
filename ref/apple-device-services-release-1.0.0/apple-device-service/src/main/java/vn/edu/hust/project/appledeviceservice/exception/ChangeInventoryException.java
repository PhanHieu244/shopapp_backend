package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class ChangeInventoryException extends ApplicationException{
    public ChangeInventoryException() {
        super(ErrorCodes.CHANGE_INVENTORY_FAIL.getMessage(), ErrorCodes.CHANGE_INVENTORY_FAIL.getCode());
    }
}
