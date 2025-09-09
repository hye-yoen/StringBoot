//package com.example.demo.Domain.Common.Service;
//
//import com.example.demo.Domain.Common.Dto.MemoDto;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//
//@SpringBootTest
//class MemoServiceTest {
//
//    @Autowired
//    private MemoService memoService;
//
//    @Test
//    public void t1() throws SQLException {
//        MemoDto dto= new MemoDto(11L,"","a@a.com", LocalDateTime.now(),null);
//        memoService.memoRegistration(dto);
//
//    }
//}