package com.example.bookdirectory.book;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookRepo extends MongoRepository<Book, Integer> {

}
