package com.springboot.springbootexam.configuration.exception;

import com.springboot.springbootexam.configuration.http.BaseResponseCode;

public class BaseException extends AbstractBaseException{
    
    public BaseException () {
    }
    
    public BaseException(BaseResponseCode responseCode) {
        this.responseCode = responseCode;
    }
    
    public BaseException(BaseResponseCode responseCode, String[] args) {
        this.responseCode = responseCode;
        this.args = args;
    }
}
