package com.example.demo.Domain.Common.Repository;

import com.example.demo.Domain.Common.Entity.Order;
import com.example.demo.Domain.Common.Entity.Order2;
import com.example.demo.Domain.Common.Entity.OrderId;
import com.example.demo.Domain.Common.Entity.OrderId2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
