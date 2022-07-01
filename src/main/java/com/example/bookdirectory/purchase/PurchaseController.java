package com.example.bookdirectory.purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PurchaseController {

    @Autowired
    PurchaseRepo purchaseRepo;

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/order-book")
    public ResponseEntity<?> orderBook(@RequestParam(name = "userId",required = true) Integer userId,
                                       @RequestParam(name = "bookId",required = true) Integer bookId,
                                       @RequestParam(name = "coupon",required = false) String coupon){
        return purchaseService.orderBook(userId,bookId,coupon);
    }

    @GetMapping("/order-book")
    public ResponseEntity<?> orderBook(){
        return ResponseEntity.ok(purchaseRepo.findAll());
    }
}
