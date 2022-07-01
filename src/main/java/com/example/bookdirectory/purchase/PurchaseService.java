package com.example.bookdirectory.purchase;

import org.springframework.http.ResponseEntity;

public interface PurchaseService {

    ResponseEntity<?> orderBook(Integer userId, Integer bookId,String coupon);
}
