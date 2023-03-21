package com.example.todolistjpa;

import com.example.todolistjpa.entity.Todo;
import com.example.todolistjpa.repository.TodoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class TodolistjpaApplicationTests {

    @Autowired
    private TodoRepository repository;

    @Test
    @Rollback(value = false)
    void save_user() {
        Faker faker = new Faker();
        System.out.println(faker.name().fullName());

    }
//    void contextLoads() {
//    }

}
