package com.example.kursach.repositories;

import com.example.kursach.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository  extends JpaRepository<Orders, Long> {
    Orders findByIdOrder(Long orderId);
}
