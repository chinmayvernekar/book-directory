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
    public ResponseEntity<?> orderBook(Integer userId, Integer bookId,String coupon) {
        Map<String,String> map = new HashMap<>();
        Book book = null;
        Purchase purchase = new Purchase();
        Random random = new Random();
        try {
            if(coupon != null && coupon.equalsIgnoreCase("FIRSTBOOK")) {
                purchase.setId(random.nextInt(9999));
                book = bookRepo.findById(bookId).orElseThrow();
                Float price = book.getPrice();
                Float discount =  30 * (price/100) ;
                purchase.setPrice(discount);
                purchase.addRole(book);
                purchase.setBookId(bookId);
                purchase.setUserId(userId);
                purchaseRepo.save(purchase);
                map.put("message", "Order Successfull.");
            }
            else {
                purchase.setId(random.nextInt(9999));
                book = bookRepo.findById(bookId).orElseThrow();
                Float price = book.getPrice();
                purchase.setPrice(price);
                purchase.addRole(book);
                purchase.setBookId(bookId);
                purchase.setUserId(userId);
                purchaseRepo.save(purchase);
                map.put("message", "Order Successfull.");
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
        return ResponseEntity.ok(map);
    }
}
