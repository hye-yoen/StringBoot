package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

//    //함수명명법
    List<Book> findByBookName(String bookName);  //변수명 앞글자 대문자//이러면 하이브레이션이 뭘 자동으로 한다고??
    List<Book> findByPublisher(String publisher);
    Book findByIsbn(String isbn); //얘는 단건 조회도 가능??
    List<Book> findByBookNameAndPublisher(String bookName, String publisher);
    List<Book> findByBookNameContains(String bookName);
}
//select * from book where bookName= ?
//select * from book where publisher= ?
//select * from book where bookname= ?  and publisher =?
//select * from book where bookName like '%?%'