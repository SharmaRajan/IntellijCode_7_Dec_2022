package com.sharmajee.FileUpload.exception;

import org.springframework.http.HttpStatus;

public class FileNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1l;
    private HttpStatus code;

    public FileNotFoundException(String message){
        super(message);
    }

    public FileNotFoundException(String message,HttpStatus code) {
        super(message);
        this.code = code;
    }

    public FileNotFoundException(String message, Throwable cause, HttpStatus code) {
        super(message, cause);
        this.code = code;
    }

    public FileNotFoundException(Throwable cause, HttpStatus code) {
        super(cause);
        this.code = code;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }
}
