package com.rsupport.rsupporthomework.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    private static String ERROR_PATH = "/error/error";

    @ExceptionHandler(NoSuchElementException.class)
    protected String handleNoSuchElementException(Exception e) {
        return ERROR_PATH;
    }
    @ExceptionHandler(TemplateInputException.class)
    protected String handleTemplateInputException(Exception e) {
        return ERROR_PATH;
    }
}
