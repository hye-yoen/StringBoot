package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {
    //매서드명명법 //메모 엔디디 , 프라이머리키 자료형
    //JPQL(SQL문직접)  -@query("Select ...)
}
