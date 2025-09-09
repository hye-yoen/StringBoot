package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user") //테이블 명 따로 지정 없으면 클래스명 == 테이블명
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(length = 100)
    private String username;
    @Column(length = 255 , nullable = false)
    private String password;
    @Column(length = 255)
    private String role;
}
