package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @DisplayName("--기본 CRUD 확인--") //사람이 더 읽기 쉽게 해주는 것 (중요 x)
    @Test
    public void t1(){
        Book book = Book.builder()
                .BookCode(1L)
                .bookName("JAVA의 정석")
                .publisher("이지믈라썸")
                .isbn("2222-1111")
                .build();

        //insert
//        bookRepository.save(book);

        //update
//        bookRepository.save(book);

        //delete
//        bookRepository.deleteById(1L);

        //select
//        Optional<Book> bookOptional = bookRepository.findById(1L); //option으로 반환
//        Book rBook = null ;
//        if (bookOptional.isPresent()){ //null 체크
//            rBook = bookOptional.get();
//            System.out.println(rBook);
//        }

        //select all
        List<Book> list = bookRepository.findAll();
        list.forEach(System.out::println); //원래는 페이징 처리 필요(데이터 사이즈가 큰 경우)

    }
    //함수 아이디가 아니라 bookName 즉 다른 걸로 조회하고 싶을 떄 -> 레파지토리 이동
    @DisplayName("--함수명명법 TEST--")
    @Test
    public void t2(){

        //bkkoname으로 찾기
//        List<Book> list = bookRepository.findByBookName("a");
//        list.forEach(System.out::println);

        //
        List<Book> list = bookRepository.findByBookNameContains("d");
        list.forEach(System.out::println);

    }

}
//걍 레파지토리를 이용해서 test