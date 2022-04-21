package com.devendrabrain.OrderManagement.repository;

import com.devendrabrain.OrderManagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepostitoy extends JpaRepository<Order, Long> {
}
