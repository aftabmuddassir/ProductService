package com.aftab.ProductService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String message;
    private String status;

    public ErrorDto() {
        // Default constructor
    }

    public ErrorDto(String message, String status) {
        this.message = message;
        this.status = status;
    }

   
}
