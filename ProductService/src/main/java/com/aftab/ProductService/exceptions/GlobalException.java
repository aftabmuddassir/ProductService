package com.aftab.ProductService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aftab.ProductService.dtos.ErrorDto;

@RestControllerAdvice
public class GlobalException {

       @ExceptionHandler(NullPointerException.class)
    public ErrorDto handleProductNotFound() {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("NPE occured");
        errorDto.setStatus("Failure");
        return errorDto;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFound(ProductNotFoundException e) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());
        errorDto.setStatus("Failure");
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
    
}
