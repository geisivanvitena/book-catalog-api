package com.geisivan.bookcatalog.controller;

import com.geisivan.bookcatalog.busines.dto.request.BookRequestDTO;
import com.geisivan.bookcatalog.busines.dto.request.BookUpdateRequestDTO;
import com.geisivan.bookcatalog.busines.dto.response.BookResponseDTO;
import com.geisivan.bookcatalog.busines.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(
            @RequestBody @Valid BookRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bookService.createBook(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> findAllBooks() {

        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<BookResponseDTO> findBookById(
            @PathVariable Long id) {

        return  ResponseEntity.ok(bookService.findBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(
            @PathVariable Long id,
            @RequestBody @Valid BookUpdateRequestDTO dto) {

        return ResponseEntity.ok(bookService.updateBook(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id) {

        bookService.deleteBook(id);

        return ResponseEntity.noContent().build();
    }
}
