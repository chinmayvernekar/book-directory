package com.example.bookdirectory.book;

import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BookService {

    public ResponseEntity<?> saveBook(Book book);

    public ResponseEntity<?> findBook(Integer bookId);

    public ResponseEntity<?> updateBook(Integer bookId,Book updateBookDetails);

    public ResponseEntity<?> deleteBook(Integer bookId);
}
