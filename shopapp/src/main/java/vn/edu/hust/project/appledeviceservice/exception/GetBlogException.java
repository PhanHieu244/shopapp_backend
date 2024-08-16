package vn.edu.hust.project.appledeviceservice.exception;

import vn.edu.hust.project.appledeviceservice.constant.ErrorCodes;

public class GetBlogException extends ApplicationException{
    public GetBlogException() {
        super(ErrorCodes.GET_BLOG_NOT_FOUND.getMessage(), ErrorCodes.GET_BLOG_NOT_FOUND.getCode());
    }
}
