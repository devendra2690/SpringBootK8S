package com.devendrabrain.OrderManagement.dao.impl;

import com.devendrabrain.OrderManagement.dao.OrderDAO;
import com.devendrabrain.OrderManagement.entity.Order;
import com.devendrabrain.OrderManagement.repository.OrderRepostitoy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDAO {

    private Logger logger = LoggerFactory.getLogger(OrderDaoImpl.class);

    @Autowired
    OrderRepostitoy orderRepostitoy;

    @Override
    public List<Order> fetchAll() {
        return orderRepostitoy.findAll();
    }

    @Override
    public Order fetchById(Long id) {
        return orderRepostitoy.findById(id).orElse(null);
    }

    @Override
    public Order create(Order order) {
        logger.info("OrderDaoImpl:create  creating order ", order);
        return orderRepostitoy.save(order);
    }

    @Override
    public void delete(Long id) {
       orderRepostitoy.deleteById(id);
    }
}
