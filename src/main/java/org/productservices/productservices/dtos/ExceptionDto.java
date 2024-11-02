package org.productservices.productservices.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ExceptionDto {
    private HttpStatus errorCode;
    private String message;

    public ExceptionDto(HttpStatus errorCode,String message) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
