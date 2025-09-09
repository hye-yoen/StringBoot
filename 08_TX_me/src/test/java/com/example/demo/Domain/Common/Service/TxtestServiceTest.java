package com.example.demo.Domain.Common.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TxtestServiceTest {
    @Autowired
    private TxtestService txtestService;

    @Test
    public void t1()throws Exception{
//        txtestService.addMemo();
        txtestService.addMemoTx();
    }

}