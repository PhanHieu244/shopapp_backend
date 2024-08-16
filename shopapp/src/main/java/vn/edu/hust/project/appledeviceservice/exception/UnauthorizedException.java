package vn.edu.hust.project.appledeviceservice.exception;

public class UnauthorizedException extends HttpFilterException{

    public UnauthorizedException() {
        super("Unauthorized");
    }
}
