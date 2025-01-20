package com.tp.GitConfig.web.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message); // Pass the message to the parent class
    }
}