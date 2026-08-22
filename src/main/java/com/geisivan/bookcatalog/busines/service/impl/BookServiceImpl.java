package com.geisivan.bookcatalog.busines.service.impl;

import com.geisivan.bookcatalog.busines.dto.request.BookRequestDTO;
import com.geisivan.bookcatalog.busines.dto.request.BookUpdateRequestDTO;
import com.geisivan.bookcatalog.busines.dto.response.BookResponseDTO;
import com.geisivan.bookcatalog.busines.mapper.BookMapper;
import com.geisivan.bookcatalog.busines.service.BookService;
import com.geisivan.bookcatalog.domain.entity.Book;
import com.geisivan.bookcatalog.infrastructure.exception.custom.ConflictException;
import com.geisivan.bookcatalog.infrastructure.exception.custom.ResourceNotFoundException;
import com.geisivan.bookcatalog.infrastructure.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    @Transactional
    public BookResponseDTO createBook(BookRequestDTO dto) {

        Book book = bookMapper.toEntity(dto);

        validateBookAlreadyExists(book.getTitle(), book.getAuthor());

        Book savedBook = bookRepository.save(book);

        return bookMapper.toDTO(savedBook);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookResponseDTO> findAllBooks() {

        List<Book> books = bookRepository.findAll();

        return books.stream().map(bookMapper::toDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BookResponseDTO findBookById(Long id) {

        Book book = getBookById(id);

        return bookMapper.toDTO(book);
    }

    @Override
    @Transactional
    public BookResponseDTO updateBook(Long id, BookUpdateRequestDTO dto) {

        Book book = getBookById(id);

        bookMapper.update(dto, book);

        Book updatedBook = bookRepository.save(book);

        return bookMapper.toDTO(updatedBook);
    }

    @Override
    @Transactional
    public void deleteBook(Long id) {

        Book book = getBookById(id);

        bookRepository.delete(book);
    }


    private void validateBookAlreadyExists(String title, String author) {

        if (bookRepository.existsByTitleAndAuthorIgnoreCase(title, author)) {
            throw new ConflictException(
                    "Book with title '" + title + "' and author '" + author + "' already exists.");
        }
    }

    private Book getBookById(Long id) {

        return bookRepository.findById(id).orElseThrow(
                () -> new  ResourceNotFoundException(
                        "Book with id '" + id + "' not found."));
    }
}
