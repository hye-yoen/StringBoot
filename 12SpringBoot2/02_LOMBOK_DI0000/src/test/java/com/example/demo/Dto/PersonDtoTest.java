package com.example.demo.Dto;

import static org.junit.jupiter.api.Assertions.*;

class PersonDtoTest {

    public void t1(){
        PersonDto dto = new PersonDto(name : "홍길동",age : 50,addr:"대구");
        System.out.println(dto);
    }
}