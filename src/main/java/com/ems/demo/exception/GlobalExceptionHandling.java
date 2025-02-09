package com.ems.demo.exception;

import com.ems.demo.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler(value = EmployeeAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ErrorResponse handlerException(EmployeeAlreadyExistException exception){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), LocalDateTime.now().toString());
    }

    @ExceptionHandler(value = NoSuchEmployeeExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse handlerException(NoSuchEmployeeExistsException exception){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now().toString());
    }
}
