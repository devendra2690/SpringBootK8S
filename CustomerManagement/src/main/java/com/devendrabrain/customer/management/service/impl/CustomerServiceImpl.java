package com.devendrabrain.customer.management.service.impl;

import com.devendrabrain.customer.management.bo.CustomerBO;
import com.devendrabrain.customer.management.dao.CustomerDAO;
import com.devendrabrain.customer.management.entity.Customer;
import com.devendrabrain.customer.management.service.CustomerService;
import com.devendrabrain.customer.management.transform.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   CustomerDAO customerDAO;

    @Override
    public List<CustomerBO> fetchAll() {

        //Fetch All records
        List<Customer> customerList = customerDAO.fetchAll();

         // Transform Customer To CustomerBO
        List<CustomerBO> customerBOList = new ArrayList<>();

        for (Customer customer : customerList) {
            CustomerBO customerBO = new CustomerBO();
            CustomerTransformer.transformCustomerTOCustomerBO(customer,customerBO);
            customerBOList.add(customerBO);
        }

        return customerBOList;
    }

    @Override
    public CustomerBO fetchById(Long id) {

        // Fetch byId
        Customer customer = customerDAO.fetchById(id);

        //Transform
        CustomerBO customerBO = CustomerTransformer.transformCustomerTOCustomerBO(customer,new CustomerBO());

        return customerBO;
    }

    @Override
    public CustomerBO createRecords(CustomerBO customerBo) {

        // Validate CustomerBO object

        // save customer object
        Customer customer = new Customer();
        CustomerTransformer.transformCustomerBOTOCustomer(customerBo,customer);
        customerDAO.createRecords(customer);

        //Transform Customer to Customer BO
        CustomerTransformer.transformCustomerTOCustomerBO(customer,customerBo);

        return customerBo;
    }

    @Override
    public CustomerBO updateRecords(CustomerBO customerBo) {
        return null;
    }

    @Override
    public void deleteRecords(Long id) {
       customerDAO.deleteRecords(id);
    }
}
