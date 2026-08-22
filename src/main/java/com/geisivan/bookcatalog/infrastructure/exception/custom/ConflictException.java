package com.geisivan.bookcatalog.infrastructure.exception.custom;

import org.springframework.http.HttpStatus;

public class ConflictException extends ApiException {

    public ConflictException(String message) {

        super(message, HttpStatus.CONFLICT);
    }
}
