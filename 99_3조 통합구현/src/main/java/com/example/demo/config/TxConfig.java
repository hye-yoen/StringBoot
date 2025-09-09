package com.example.demo.config;
// 트랜잭션 관리 설정 클래스

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration // 스프링 설정 클래스임을 명시
@EnableTransactionManagement    // @Transactional 사용 가능하게 설정
public class TxConfig {

    @Autowired
    private DataSource dataSource;  // DB 연결 정보 (HikariDataSource)

    @Bean(name="jpaTransactionManager")     // Bean 이름 지정
    public JpaTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) {
        //트랜잭션 기본 코드 작성
        // 트랜잭션 매니저 객체 생성
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        // JPA EntityManagerFactory 주입 (엔티티 관리)
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        // DB 연결 정보 주입 (데이터소스 관리)
        transactionManager.setDataSource(dataSource);

        return transactionManager;
    }

}

// 실행 흐름
// 1. 스프링 실행 시 TxConfig 설정 로딩
// 2. JpaTransactionManager 스프링 빈으로 등록
// 3. 서비스 계층(@Service)에서 @Transcational 붙은 메서드 실행 -> 해당 매니저가 트랜잭션 시작
// 4. 메서드 실행 중 정상 완료 -> commit()
// 5. 실행 중 예외 발생 -> rollback()