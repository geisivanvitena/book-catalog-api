package com.geisivan.bookcatalog.busines.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookRequestDTO(

        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Author is required")
        String author,

        @NotBlank(message = "Category is required")
        String category,

        @NotNull(message = "Publication year is required")
        Long publicationYear
) {}
