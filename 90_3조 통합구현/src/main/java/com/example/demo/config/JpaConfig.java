package com.example.demo.config;
// Hibernate란?
// 자바객체(클래스)와 데이터베이스 테이블을 자동으로 매핑해주는 도구


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration // 스프링 설정 클래스임을 명시
@EntityScan(basePackages = {"com.example.demo.domain.entity"})  // JPA 엔티티 스캔
@EnableJpaRepositories
(
                basePackages ="com.example.demo.domain.repository",     // JPA Repository 스캔
                transactionManagerRef = "jpaTransactionManager"         // 사용할 트랜잭션을 위한 빈의 이름 지정
)
public class JpaConfig {
    @Autowired
    private DataSource dataSource;      // DataSourceConfig에서 만든 HikariDataSource 주입

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        // 엔티티 매니저 팩토리 객체 생성
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        // DB 연결정보(DataSource) 주입
        entityManagerFactoryBean.setDataSource(dataSource);
        // Hibernate JPA 구현체 설정
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        // 엔티티 스캔 패키지 지정
        entityManagerFactoryBean.setPackagesToScan("com.example.demo.domain.entity");

//        Properties jpaProperties = new Properties();

        // Hibernate 관련 속성
        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");                         // 엔티티 변경 시 DB 스키마 자동 반영
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", true);                                 // SQL 출력
        properties.put("hibernate.format_sql", true);                               // SQL 정렬
        properties.put("hibernate.hibernate.jdbc.batch_size", 1000);                // 배치 insert/update
        properties.put("hibernate.hibernate.order_inserts", true);                  // insert 정렬 최적화
        properties.put("hibernate.order_updates", true);                            // update 정렬 최적화
        properties.put("hibernate.jdbc.batch_versioned_data", true);                // 버전 관리된 데이터도 배치처리
        // 설정된 속성을 팩토리에 적용
        entityManagerFactoryBean.setJpaPropertyMap(properties);

        return entityManagerFactoryBean;
    }

}

// 실행 흐름
// 1. 스프링부트 시작 시 JpaConfig 읽음
// 2. entityManagerFactory() 실행 -> JPA용 EntityManagerFactory 객체 생성
// 3. DataSourceConfig에서 등록된 DB 연결정보 사용
// 4. Hibernate 속성을 적용하여 DB연동 준비
// 5. Repository 호출 시 엔티티 메니저를 통해 DB CRUD 수행

// 이 클래스는 JPA + Hibernate 환경 세팅 담당자
// DataSource가 "DB 연결 준비", JapConfig는 "JPA로 DB 다루는 방법 준비"