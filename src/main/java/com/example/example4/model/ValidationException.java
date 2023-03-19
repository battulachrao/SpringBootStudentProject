package com.example.example4.model;

public class ValidationException extends Exception{
    private String errorCode;
    private  String errorMessage;
    public ValidationException() {


    }
    public ValidationException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ValidationException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }



}
