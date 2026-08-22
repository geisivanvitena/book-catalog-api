package com.geisivan.bookcatalog.infrastructure.exception.custom;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException(String message) {

        super(message, HttpStatus.NOT_FOUND);
    }
}
