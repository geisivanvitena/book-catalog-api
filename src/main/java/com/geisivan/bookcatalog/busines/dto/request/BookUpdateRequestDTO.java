package com.geisivan.bookcatalog.busines.dto.request;

public record BookUpdateRequestDTO(
        String title,
        String author,
        String category,
        Long publicationYear
) {}
