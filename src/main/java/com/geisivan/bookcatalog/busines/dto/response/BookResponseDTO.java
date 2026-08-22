package com.geisivan.bookcatalog.busines.dto.response;

public record BookResponseDTO(
        Long id,
        String title,
        String author,
        String category,
        Long publicationYear
) {}
