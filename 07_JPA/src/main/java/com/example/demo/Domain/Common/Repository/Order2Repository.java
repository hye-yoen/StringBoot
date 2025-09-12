package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Order2;
import com.example.demo.Domain.Common.Entity.OrderId2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order2Repository extends JpaRepository<Order2,OrderId2> {
//Entity , IDType : 여기선 OrderId2에 설정 했으므로 그 클래스 가져옴
}
