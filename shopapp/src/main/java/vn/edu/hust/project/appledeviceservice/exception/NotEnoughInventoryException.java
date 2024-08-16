package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class NotEnoughInventoryException extends ApplicationException{
    public NotEnoughInventoryException() {
        super(ErrorCodes.NOT_ENOUGH_INVENTORY.getMessage(), ErrorCodes.NOT_ENOUGH_INVENTORY.getCode());
    }
}
