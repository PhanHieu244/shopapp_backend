package vn.edu.hust.project.appledeviceservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import vn.edu.hust.project.appledeviceservice.enitity.dto.response.Resource;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Resource> handleApplicationException(ApplicationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new Resource(ex.getCode(), ex.getMessage()));
    }

    @ExceptionHandler(HttpFilterException.class)
    public ResponseEntity<Resource> handleUnauthorizedException(HttpFilterException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body(new Resource(ex.getCode(), ex.getMessage()));
    }
}
