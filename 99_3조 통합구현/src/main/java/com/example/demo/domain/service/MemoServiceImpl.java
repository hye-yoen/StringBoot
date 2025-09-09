package com.example.demo.domain.service;
// MemoService 인터페이스의 구현체
// 실제 메모 저장 비즈니스 로직을 수행하는 서비스 계층 클래스

import com.example.demo.domain.dto.MemoDto;
import com.example.demo.domain.entity.Memo;
import com.example.demo.domain.repository.MemoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Service    // 서비스 계층 빈 등록
@Slf4j      // 로그 사용 가능
public class MemoServiceImpl implements MemoService {
    //JPA REPOSITORY
    @Autowired
    private MemoRepository memoRepository;  // DB 접근(JPA Repository)

    //트랜잭션 설정할 것
    // 메모 저장 서비스 로직
    @Override
    @Transactional(rollbackFor = SQLException.class,        //SQLException 발생 시 롤백
            transactionManager = "jpaTransactionManager"    //JPA 트랜잭션 매니저 사용
    )
    public Long addMemoTx(MemoDto dto) throws Exception {
        log.info("MemoService's addMemoTx2 Call!");
        //코드 완성
        // 1. DTO -> 엔티티 변환
        Memo memo = dto.toEntity();

        // 2. JPA save()로 DB 저장
        memoRepository.save(memo);

        // 3. 저장된 엔티티의 ID 반환
        return memo.getId();
    }
}












// 실행 흐름
// 1. 컨트롤러 (MemoController.add_post)->memoService.addMemoTx(dto)호출
// 2. 서비스 계층에서 DTO를 엔티티로 변환(dto.toEntity())
// 3. memoRepository.save(memo) 실행 -> Hibrnate가 SQL(INSERT) 실행
// 4. DB에 메모 저장 후, 자동 생성된 ID를 반환