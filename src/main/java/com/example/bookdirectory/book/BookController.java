package com.example.bookdirectory.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/save-book")
    public ResponseEntity<?> saveBook(@RequestBody Book book){
      return   bookService.saveBook(book);
    }

    @GetMapping("/find-book")
    public ResponseEntity<?> findBook(@RequestParam(name = "bookId",required = false) Integer bookId){
        return bookService.findBook(bookId);
    }

    @PutMapping("/update-book/{bookid}")
    public ResponseEntity<?> updateBook(@PathVariable(name = "bookid") Integer bookId,
                                       @RequestBody Book updateBookDetails){
        return bookService.updateBook(bookId,updateBookDetails);
    }

    @DeleteMapping("/delete-book")
    public ResponseEntity<?> deleteBook(@RequestParam(name = "bookId",required = true) Integer bookId){
        return bookService.deleteBook(bookId);
    }
}
