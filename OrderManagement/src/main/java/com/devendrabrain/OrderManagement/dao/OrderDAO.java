package com.devendrabrain.OrderManagement.dao;

import com.devendrabrain.OrderManagement.entity.Order;

import java.util.List;

public interface OrderDAO {

    List<Order> fetchAll();
    Order fetchById(Long id);
    Order create(Order order);
    void delete(Long id);
}
