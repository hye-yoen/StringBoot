package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "book") //테이블 명 따로 지정 없으면 클래스명 == 테이블명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private long BookCode;
    private String bookName;
    private String publisher;
    private String isbn;
}
//실행하면 DB에서 속성이 만들어짐
