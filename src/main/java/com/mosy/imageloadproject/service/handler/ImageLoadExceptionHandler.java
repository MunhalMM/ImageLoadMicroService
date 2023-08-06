package com.mosy.imageloadproject.service.handler;

import com.mosy.imageloadproject.apiresponce.ApiResponse;
import com.mosy.imageloadproject.exceptions.SizeLimitException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ImageLoadExceptionHandler {

    @ExceptionHandler
    public ResponseEntity sizeLimitHandler(SizeLimitException sizeLimitException, HttpServletRequest request) {
        return new ResponseEntity<ApiResponse>(ApiResponse.error(sizeLimitException.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity illegalArgumentHandler(IllegalArgumentException illegalArgumentException, HttpServletRequest request) {
        return new ResponseEntity<ApiResponse>(ApiResponse.error(illegalArgumentException.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }
}
