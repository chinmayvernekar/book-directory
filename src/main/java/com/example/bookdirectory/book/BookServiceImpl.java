package com.example.bookdirectory.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public ResponseEntity<?> saveBook(Book book) {
        Map<String,String> map = new HashMap<>();
        Random random = new Random();
        try {
            book.setId(random.nextInt(9999));
            bookRepo.save(book);
            map.put("message","Book Inserted.");
        }catch (Exception e){

        }
        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<?> findBook(Integer bookId) {
        Book book = null;
        List<Book> books = null;
        try {
            if(bookId != null){
                book= bookRepo.findById(bookId).orElseThrow();
            }
            else {
                books =  bookRepo.findAll();
                return ResponseEntity.ok(books);
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return ResponseEntity.ok(book);
    }
}
