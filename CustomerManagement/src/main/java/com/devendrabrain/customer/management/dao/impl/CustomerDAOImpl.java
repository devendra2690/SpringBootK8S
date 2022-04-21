package com.devendrabrain.customer.management.dao.impl;

import com.devendrabrain.customer.management.dao.CustomerDAO;
import com.devendrabrain.customer.management.entity.Customer;
import com.devendrabrain.customer.management.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> fetchAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer fetchById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer createRecords(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateRecords(Customer customer) {
        return null;
    }

    @Override
    public void deleteRecords(Long customerId) {
         customerRepository.deleteById(customerId);
    }
}
