package com.ems.demo.exception;

public class EmployeeAlreadyExistException extends RuntimeException {

    private String message;

    public EmployeeAlreadyExistException(){

    }

    public EmployeeAlreadyExistException(String msg){
        super(msg);
        this.message=msg;
    }
}
