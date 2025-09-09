package com.example.demo.Config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration //설정 빈 만들기
public class DataSourceConfig {

    @Bean
    public DataSource dataSource2(){
        //DB 사용 설정?
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        dataSource.setInitialSize(5); //초기 연결갯수 //실행될때 5개 연결을 만들어 둠
        dataSource.setMaxTotal(10); //최대 동시 연결 개수
        dataSource.setMaxIdle(8); //최대 유휴(쉬고 있는) 연결 수
        dataSource.setMaxIdle(3); //최소 유휴 갯수

        return dataSource; //의존주입받아서 연결
    }

    @Bean
    public HikariDataSource dataSource3(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");

        return dataSource;
    }
}
