package com.example.bookdirectory.purchase;

import com.example.bookdirectory.book.Book;
import com.example.bookdirectory.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
public class PurchaseServiceImpl implements PurchaseService{

    @Autowired
    BookRepo bookRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

    @Override
    public ResponseEntity<?> orderBook(Integer userId, Integer bookId) {
        Map<String,String> map = new HashMap<>();
        Book book = null;
        Purchase purchase = new Purchase();
        Random random = new Random();
        try {
            purchase.setId(random.nextInt(9999));
            book = bookRepo.findById(bookId).orElseThrow();
            purchase.addRole(book);
            purchase.setBookId(bookId);
            purchase.setUserId(userId);
            purchaseRepo.save(purchase);
            map.put("message","Order Successfull.");
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return ResponseEntity.ok(map);
    }
}
