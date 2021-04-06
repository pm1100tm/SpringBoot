package com.springboot.springbootexam.configuration.exception;

import com.springboot.springbootexam.configuration.http.BaseResponseCode;

public abstract class AbstractBaseException extends RuntimeException{
    
    protected BaseResponseCode responseCode;
    protected Object[] args;
    
    public AbstractBaseException(){}
    
    public AbstractBaseException(BaseResponseCode responseCode){
        this.responseCode = responseCode;
    }
    
    public BaseResponseCode getResponseCode() {
        return responseCode;
    }
    
    public Object[] getArgs(){
        return args;
    }
}
