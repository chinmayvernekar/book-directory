package com.example.bookdirectory.purchase;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepo extends MongoRepository<Purchase,Integer> {
}
