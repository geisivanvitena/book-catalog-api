package com.geisivan.bookcatalog.infrastructure.exception.handler.response;

import com.geisivan.bookcatalog.infrastructure.exception.handler.errorcode.ErrorCode;
import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponseDTO(

        LocalDateTime timestamp,
        int status,
        String error,
        String message,
        String path,
        ErrorCode errorCode,
        List<String>errors
) {}
