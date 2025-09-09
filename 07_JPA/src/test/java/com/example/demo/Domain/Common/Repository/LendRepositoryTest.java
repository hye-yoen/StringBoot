package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import com.example.demo.Domain.Common.Entity.Lend;
import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LendRepositoryTest {
    @Autowired
    private LendRepository lendRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  BookRepository bookRepository;

    @Test
    public void t1(){
        //select
        List<Lend> list = lendRepository.findAll();
        list.forEach(System.out::println);

        //insert
//        User user = userRepository.findById("user1").get();
//        Book book = bookRepository.findById(1L).get();
//
//        Lend lend = Lend.builder()
//                .id(null)
//                .user(user)
//                .book(book)
//                .build();
//
//        lendRepository.save(lend);


        //수정이나 삭제도 user,book을 구해와서 해야함
        //update
        User user = userRepository.findById("user1").get();
        Book book = bookRepository.findById(1L).get();


        //delete
    }
}