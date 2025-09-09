package com.example.demo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration  // 스프링 설정 클래스임을 명시
public class DataSourceConfig {

	@Bean   // HikariDataSource 객체를 스프링 빈으로 등록
	public HikariDataSource dataSource()
	{
        //HikariDataSource 사용할 것
        HikariDataSource dataSource = new HikariDataSource();           // 1) HikariCP 기반 DataSource 생성
        //Mysql Connection
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");      // 2) MySQL 드라이버 지정
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");    // 3) 접속할 DB URL (현재: testdb 스키마)
        // Id : root
        dataSource.setUsername("root");                                 // 4) DB 접속 ID
        // Pw : 1234
        dataSource.setPassword("1234");                                 // 5) DB 접속 PW
        return dataSource;                                              // 설정이 끝난 DataSource 반환 → Bean 등록됨
	}

}


// 주요 기능
// 1. @Configration
//  - 스프링 설정 클래스임을 선언
//  - 스프링이 이 클래스를 읽고, 내부의 @Bean을 컨테이너에 등록

// 2. @Bean
//  - 반환하는 객체(HikariDataSource)를 스프링 빈으로 등록
//  - 이후 Repository/JPA 등에서 DB 접근 시 이 빈을 사용

// 3. HikariDataSource
//  - 스프링부트의 기본 커넥션 풀(성능이 좋아서 기본으로 채택됨)
