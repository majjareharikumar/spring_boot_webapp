package com.javaguide.Spring_boot_restful_webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private String UserName;
    private String FieldName;
    private  Long FieldValue;

    public UserNotFoundException(String userName,String fieldName,Long fieldValue){
        super(String.format("%s not found by id %s:- %s",userName,fieldName,fieldValue));
        this.UserName=userName;
        this.FieldName=fieldName;
        this.FieldValue=fieldValue;
    }

}
