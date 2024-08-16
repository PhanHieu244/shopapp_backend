package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateInventoryException extends ApplicationException{
    public CreateInventoryException() {
        super(ErrorCodes.CREATE_INVENTORY_FAIL.getMessage(), ErrorCodes.CREATE_INVENTORY_FAIL.getCode());
    }
}
