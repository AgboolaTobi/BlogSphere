package com.BlogSphere.Blog.exceptions;


import com.BlogSphere.Blog.utils.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogException.class)
    public ResponseEntity<ApiResponse> blogException(BlogException exception){
        return new ResponseEntity<>(ApiResponse.builder()
                .data(exception.getMessage())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .isSuccessful(false)
                .build(), HttpStatus.BAD_REQUEST);
    }


}
