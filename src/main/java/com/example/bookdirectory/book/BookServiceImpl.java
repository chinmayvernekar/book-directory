package com.example.bookdirectory.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.*;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public ResponseEntity<?> saveBook(Book book) {
//        Map<String,String> map = new HashMap<>();
        Random random = new Random();
        try {
            book.setId(random.nextInt(9999));
            bookRepo.save(book);
//            map.put("message","Book Inserted.");
        }catch (Exception e){

        }
        return ResponseEntity.ok(book);
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

    @Override
    public ResponseEntity<?> updateBook(Integer bookId,Book updateBookDetails) {
        Map<String, Object> map = new HashMap<>();

        try {
            Book getById = bookRepo.findById(bookId).orElseThrow();
            getById.setTitle(updateBookDetails.getTitle());
            getById.setImageUri(updateBookDetails.getImageUri());
            getById.setDateOfPublication(updateBookDetails.getDateOfPublication());
            getById.setChapter(updateBookDetails.getChapter());
            getById.setPrice(updateBookDetails.getPrice());

           final Book update = bookRepo.save(getById);
           map.put("message","Updated Sucessfully.");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return ResponseEntity.ok(map);
    }

    @Override
    public ResponseEntity<?> deleteBook(Integer bookId) {
        Map<String,String> map = new HashMap<>();
        try {
            bookRepo.deleteById(bookId);
            map.put("message","Book with id: "+ bookId + " deleted.");
        }catch (Exception e){

        }
        return ResponseEntity.ok(map);
    }
}
