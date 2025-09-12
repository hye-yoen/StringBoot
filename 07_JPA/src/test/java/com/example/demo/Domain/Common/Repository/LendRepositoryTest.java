package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import com.example.demo.Domain.Common.Entity.Lend;
import com.example.demo.Domain.Common.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
//        List<Lend> list = lendRepository.findAll();
//        list.forEach(System.out::println);

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
//        User user1 = userRepository.findById("user1").get();
//        Book book1 = bookRepository.findById(1L).get();
//
//        User user2 = userRepository.findById("user2").get();
//        Book book2 = bookRepository.findById(2L).get();
//
//        Lend lend = Lend.builder()
//                .id(2L) //바꿀 컬명 줄 지정 -> 바꾸고 싶은 해당 id의 줄을 지정
//                .user(user1)
//                .book(book1)
////                .id(1L)
////                .user(user2)
////                .book(book2)
//                .build();
//        lendRepository.save(lend);
//
//        //delete
//        lendRepository.deleteById(3L);
    }

    @Test
    public void t2(){
        //user1 bookcode 1L 대여
        User user1 = userRepository.findById("user1").get();
        Book book1 = bookRepository.findById(1L).get();
//
//        Lend lend1 = Lend.builder()
//                .id(null)
//                .user(user)
//                .book(book)
//                .build();
//        lendRepository.save(lend1);
        //also
//        Lend lend1 = new Lend();
//        lend1.setBook(book1);
//        lend1.setUser(user1);
//        lendRepository.save(lend1);


        //user1 bookcode 2L 대여
//        Book book2 = bookRepository.findById(2L).get();
//
//        Lend lend2 = Lend.builder()
//                .id(null)
//                .user(user1)
//                .book(book2)
//                .build();
//        lendRepository.save(lend2);

        //user2 bookcode 3L 대여
//        User user2 = userRepository.findById("user2").get();
//        Book book3 = bookRepository.findById(3L).get();
//
//        Lend lend3 = Lend.builder()
//                .id(null)
//                .user(user2)
//                .book(book3)
//                .build();
//        lendRepository.save(lend3);

        //user3 bookcode 4L 대여
//        User user3 = userRepository.findById("user3").get();
//        Book book4 = bookRepository.findById(4L).get();
//
//        Lend lend4 = Lend.builder()
//                .id(null)
//                .user(user3)
//                .book(book4)
//                .build();
//        lendRepository.save(lend4);

    }

    @Test
    public void t3(){
//        List<Lend> list = lendRepository.findAllLendsByUser("user1");
//        //화장실 가고 싶어요
//        list.forEach(System.out::println);

//        List<Lend> list = lendRepository.findAllLendsByUser("명품자바");
//        list.forEach(System.out::println);

    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void t4(){
        System.out.println("-------------- FETCH TEST START");
        Optional<Lend> lendOptional = lendRepository.findById(1L);
        System.out.println("----------------- lendRepository.findById(1L) invoke!----");
        Lend lend = lendOptional.get();
        System.out.println("----------------- lendRepository.get() invoke!----");
        User user = lend.getUser(); //꺼내오고
        System.out.println(user);
        System.out.println("----------------- lend.getUser() invoke!----");
        Book book = lend.getBook();
        System.out.println(book);
        System.out.println("----------------- lend.getBook() invoke!----");
        System.out.println("-------------- FETCH TEST END");
    }








}