package com.geisivan.bookcatalog.infrastructure.exception.handler;

import com.geisivan.bookcatalog.infrastructure.exception.custom.ApiException;
import com.geisivan.bookcatalog.infrastructure.exception.handler.errorcode.ErrorCode;
import com.geisivan.bookcatalog.infrastructure.exception.handler.response.ErrorResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponseDTO> handleApiException(
            ApiException exception,
            HttpServletRequest request) {

        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new ErrorResponseDTO(
                        LocalDateTime.now(),
                        exception.getHttpStatus().value(),
                        exception.getHttpStatus().getReasonPhrase(),
                        exception.getMessage(),
                        request.getRequestURI(),
                        ErrorCode.BUSINESS_ERROR,
                        List.of()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseDTO> handleValidationException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new  ErrorResponseDTO(
                        LocalDateTime.now(),
                        HttpStatus.BAD_REQUEST.value(),
                        HttpStatus.BAD_REQUEST.getReasonPhrase(),
                        "Validation error",
                        request.getRequestURI(),
                        ErrorCode.VALIDATION_ERROR,
                        errors));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleInternalException(
            Exception exception,
            HttpServletRequest request) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new  ErrorResponseDTO(
                        LocalDateTime.now(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                        "Internal server error. Please contact support.",
                        request.getRequestURI(),
                        ErrorCode.INTERNAL_ERROR,
                        List.of()));
    }
}
