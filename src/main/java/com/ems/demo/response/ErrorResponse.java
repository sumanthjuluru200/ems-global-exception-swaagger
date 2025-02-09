package com.ems.demo.response;

import java.time.LocalDateTime;

public class ErrorResponse {

    private int statusCode;
    private String ErrorMessage;
    private String timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, String errorMessage, String timeStamp) {
        this.statusCode = statusCode;
        ErrorMessage = errorMessage;
        this.timeStamp = timeStamp;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "statusCode=" + statusCode +
                ", ErrorMessage='" + ErrorMessage + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
