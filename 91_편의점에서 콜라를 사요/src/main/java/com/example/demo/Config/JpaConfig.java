package com.example.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

//이거 빈 부터 한 번더 이해 필요
@Configuration
@EntityScan(basePackages = {"com.example.demo.Domain.Common.Emtity"})
//말그대로 엔티티 가져오는 것 => @Entity를 JPA가 인식
@EnableJpaRepositories( //레파지토리 패키지 지정
    basePackages = "com.example.demo.Domain.Common.Repository",
    transactionManagerRef = "jpaTransactionManager"
)
public class JpaConfig {
    @Autowired
    private DataSource dataSource;

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
