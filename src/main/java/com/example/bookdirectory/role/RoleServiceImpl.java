package com.example.bookdirectory.role;

import com.example.bookdirectory.book.Book;
import com.example.bookdirectory.book.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService,CommandLineRunner {

    @Autowired
    RoleRepo roleRepo;



    @Override
    public void run(String... args) throws Exception {

        roleRepo.saveAll(Arrays.asList(
                new Role(1,"USER"),
                new Role(2,"ADMIN")
        ));
    }

    @Override
    public ResponseEntity<?> saveRole(Role role) {

        return ResponseEntity.ok( roleRepo.save(role));
    }




}
