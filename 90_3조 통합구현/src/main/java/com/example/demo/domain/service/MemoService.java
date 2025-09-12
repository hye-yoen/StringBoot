package com.example.demo.domain.service;
// 비즈니스 로직을 정의하는 서비스 계층의 인터페이스
// 컨트롤러(MemoController)와 래포지토리(MemoRepository) 사이에서 역할을 분리
// 구현체(MemoServiceImpl)가 반드시 구현해야 할 메서드를 정의


import com.example.demo.domain.dto.MemoDto;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

public interface MemoService    //구현체가 구현해야 할 메서드를 정의
{
    //메모 저장 서비스 메서드
    @Transactional(rollbackFor = SQLException.class,        //SQLException 발생 시 롤백
            transactionManager = "jpaTransactionManager"    //JPA 트랜잭션 매니저 사용
    )
    Long addMemoTx(MemoDto dto) throws Exception;
}
