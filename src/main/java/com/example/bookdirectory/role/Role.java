package com.example.bookdirectory.role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document(collection = "role")
public class Role {

    @Id

    private Integer id;


    private String name;


    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
