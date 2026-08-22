package com.geisivan.bookcatalog.busines.mapper;

import com.geisivan.bookcatalog.busines.dto.request.BookRequestDTO;
import com.geisivan.bookcatalog.busines.dto.request.BookUpdateRequestDTO;
import com.geisivan.bookcatalog.busines.dto.response.BookResponseDTO;
import com.geisivan.bookcatalog.domain.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(BookRequestDTO dto) {

        return Book.builder()
                .title(dto.title())
                .author(dto.author())
                .category(dto.category())
                .publicationYear(dto.publicationYear())
                .build();
    }

    public BookResponseDTO toDTO(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getCategory(),
                book.getPublicationYear());
    }

    public void update(BookUpdateRequestDTO dto, Book book) {

        if (dto.title() != null && !dto.title().isEmpty()) {
            book.setTitle(dto.title());
        }
        if (dto.author() != null && !dto.author().isEmpty()) {
            book.setAuthor(dto.author());
        }
        if (dto.category() != null && !dto.category().isEmpty()) {
            book.setCategory(dto.category());
        }
        if (dto.publicationYear() != null) {
            book.setPublicationYear(dto.publicationYear());
        }
    }
}
