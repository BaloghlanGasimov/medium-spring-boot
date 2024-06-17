package com.example.msmediumprojectbmweb.controller;

import com.example.msmediumprojectbmweb.exceptions.NotFound;
import com.example.msmediumprojectbmweb.model.ExceptionDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler(NotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handle(NotFound e){
        log.error(e.getConsoleMessage());
        return new ExceptionDto(e.getError());
    }

}
