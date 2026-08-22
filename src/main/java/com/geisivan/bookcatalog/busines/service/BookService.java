package com.geisivan.bookcatalog.busines.service;

import com.geisivan.bookcatalog.busines.dto.request.BookRequestDTO;
import com.geisivan.bookcatalog.busines.dto.request.BookUpdateRequestDTO;
import com.geisivan.bookcatalog.busines.dto.response.BookResponseDTO;
import java.util.List;

public interface BookService {

    BookResponseDTO createBook(BookRequestDTO dto);

    List<BookResponseDTO> findAllBooks();

    BookResponseDTO findBookById(Long id);

    BookResponseDTO updateBook(Long id, BookUpdateRequestDTO dto);

    void deleteBook(Long id);
}
