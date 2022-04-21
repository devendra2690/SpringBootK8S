package com.devendrabrain.customer.management.dao;

import com.devendrabrain.customer.management.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> fetchAll();
    public Customer fetchById(Long id);
    public Customer createRecords(Customer customerBo);
    public Customer updateRecords(Customer customerBo);
    public void deleteRecords(Long id);
}
