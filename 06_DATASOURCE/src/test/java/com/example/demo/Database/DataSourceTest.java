package com.example.demo.Database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DataSourceTest {
//    @Autowired
//    private DataSource dataSource;
//
//    @Test
//    public void t1() throws Exception{
//        assertNotNull("dataSource"); //걍 null 검사
//        System.out.println(dataSource);
//        Connection conn = dataSource.getConnection();
//        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
//        pstmt.setLong(1,1L);
//        pstmt.setString(2,"내용내용...");
//        pstmt.setString(3,"test@naver.com");
//        pstmt.setString(4, LocalDateTime.now().toString());
//        int result = pstmt.executeUpdate();
//    }

    @Autowired
    private DataSource dataSource2; //DataSourceConfig에 있는 변수 명과 같아야 함!

    @Test
    public void test2() throws  Exception{
        assertNotNull("dataSource2"); //걍 null 검사
        System.out.println(dataSource2);
        Connection conn = dataSource2.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setLong(1,2L);
        pstmt.setString(2,"내용내용...");
        pstmt.setString(3,"test2@naver.com");
        pstmt.setString(4, LocalDateTime.now().toString());
        int result = pstmt.executeUpdate();
    }

    @Autowired
    private DataSource dataSource3; //업캐스팅 DataSource >  HikariDataSource

    @Test
    public void test3() throws  Exception{
        assertNotNull("dataSource3"); //걍 null 검사
        System.out.println(dataSource3);
        Connection conn = dataSource3.getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into tbl_memo values(?,?,?,?)");
        pstmt.setLong(1,3L);
        pstmt.setString(2,"내용내용...");
        pstmt.setString(3,"test3@naver.com");
        pstmt.setString(4, LocalDateTime.now().toString());
        int result = pstmt.executeUpdate();
    }

}
