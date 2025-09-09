package com.example.demo.domain.repository;
// 메모 엔티티(Memo)와 DB를 연결하는 DAO(Data Access Object) 역할
// JpaRepository를 상속받아 CRUD 기능을 자동으로 제공받음


import com.example.demo.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
    // JpaRepository 기본 CRUD 메서드를 모두 상속받음

}

// 실행 흐름
// 1. 서비스(MemoServiceImpl)가 memoRepository.save(memo)호출
// 2. JPA -> Hibernate -> SQL 변환(INSERT INTO memo...)
// 3. DB에 실제 데이터 저장
// 4. 저장된 엔티티의 ID값 변환