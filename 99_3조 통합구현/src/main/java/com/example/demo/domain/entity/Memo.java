package com.example.demo.domain.entity;
// DB 테이블과 매핑되는 JPA 엔티티 클래스
// memo 테이블과 직접 연결되어 CRUD작업이 가능

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity                 // JPA 엔티티 클래스
@Table(name = "memo")   // DB 테이블 이름 지정
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {
    @Id                                                 //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // MySQL의 AUTO_INCREMENT 전략 사용
    private Long id;                // 자동으로 1씩 증가되며 값 입력

    @Column(length = 1024)
    private String text;            // 메모 본문 (최대 1024자)

    @Column(length = 100, nullable = false)
    private String writer;          // 작성자 (NULL 불가, 최대 100자)

    private LocalDateTime createAt; // 생성 시각
}
