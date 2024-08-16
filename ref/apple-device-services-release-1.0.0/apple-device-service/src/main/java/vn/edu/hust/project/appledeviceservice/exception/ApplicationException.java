package vn.edu.hust.project.appledeviceservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ApplicationException extends RuntimeException {
    private String message;
    private Long code;

    public ApplicationException(String message){
        this.message = message;
        this.code = (long) HttpStatus.BAD_REQUEST.value();
    }
}