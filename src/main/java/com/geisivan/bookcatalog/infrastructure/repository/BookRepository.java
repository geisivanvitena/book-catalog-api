package com.geisivan.bookcatalog.infrastructure.repository;

import com.geisivan.bookcatalog.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsByTitleAndAuthorIgnoreCase(String title, String author);
}
