package com.devendrabrain.customer.management.service;

import com.devendrabrain.customer.management.bo.CustomerBO;

import java.util.List;

public interface CustomerService {

    public List<CustomerBO> fetchAll();
    public CustomerBO fetchById(Long id);
    public CustomerBO createRecords(CustomerBO customerBo);
    public CustomerBO updateRecords(CustomerBO customerBo);
    public void deleteRecords(Long id);
}
