package com.example.msmediumprojectbmweb.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFound extends RuntimeException{
    private String consoleMessage;
    private String error;
    public NotFound(String error,String consoleMessage){
        super(error);
        this.error=error;
        this.consoleMessage = consoleMessage;
    }
}
