package com.example.demo.Domain.Common.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@IdClass(OrderId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private Long orderId;

    @Id
    private Long productId;

    private int quantity;
}
