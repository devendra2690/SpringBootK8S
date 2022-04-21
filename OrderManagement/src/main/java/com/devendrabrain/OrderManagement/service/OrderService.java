package com.devendrabrain.OrderManagement.service;

import com.devendrabrain.OrderManagement.bo.OrderBO;

import java.util.List;

public interface OrderService {

    public List<OrderBO> findAll();
    public OrderBO fetchById(Long orderId);
    public OrderBO create(OrderBO orderBO);
    public void delete(Long orderId);
}
