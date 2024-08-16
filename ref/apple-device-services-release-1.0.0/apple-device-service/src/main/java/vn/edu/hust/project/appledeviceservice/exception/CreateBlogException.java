package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class CreateBlogException extends ApplicationException{
    public CreateBlogException() {
        super(ErrorCodes.CREATE_BLOG_FAIL.getMessage(), ErrorCodes.CREATE_BLOG_FAIL.getCode());
    }
}
