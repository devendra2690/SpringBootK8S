package com.devendrabrain.customer.management.transform;

import com.devendrabrain.customer.management.bo.CustomerBO;
import com.devendrabrain.customer.management.dto.CustomerDTO;
import com.devendrabrain.customer.management.entity.Customer;
import org.apache.commons.lang3.StringUtils;

public class CustomerTransformer {

    public static CustomerDTO transformCustomerBOTOCustomerDTO(CustomerBO customerBO, CustomerDTO customerDTO) {


        if(customerBO != null) {
            if(customerBO.getCustomerId() != null) {
                customerDTO.setCustomerId(customerBO.getCustomerId());
            }
            if(StringUtils.isNotBlank(customerBO.getFirstName())) {
                customerDTO.setFirstName(customerBO.getFirstName());
            }
            if(StringUtils.isNotBlank(customerBO.getLastName())) {
                customerDTO.setLastName(customerBO.getLastName());
            }
            if(StringUtils.isNotBlank(customerBO.getEmailId())) {
                customerDTO.setEmailId(customerBO.getEmailId());
            }
            if(StringUtils.isNotBlank(customerBO.getPhoneNumber())) {
                customerDTO.setPhoneNumber(customerBO.getPhoneNumber());
            }
        }

        return customerDTO;
    }

    public static CustomerBO transformCustomerDTOTOCustomerBO(CustomerDTO customerDTO, CustomerBO customerBO) {

        if(customerDTO != null) {
            if(customerDTO.getCustomerId() != null) {
                customerBO.setCustomerId(customerDTO.getCustomerId());
            }
            if(StringUtils.isNotBlank(customerDTO.getFirstName())) {
                customerBO.setFirstName(customerDTO.getFirstName());
            }
            if(StringUtils.isNotBlank(customerDTO.getLastName())) {
                customerBO.setLastName(customerDTO.getLastName());
            }
            if(StringUtils.isNotBlank(customerDTO.getEmailId())) {
                customerBO.setEmailId(customerDTO.getEmailId());
            }
            if(StringUtils.isNotBlank(customerDTO.getPhoneNumber())) {
                customerBO.setPhoneNumber(customerDTO.getPhoneNumber());
            }
        }

        return customerBO;
    }

    public static Customer transformCustomerBOTOCustomer(CustomerBO customerbo, Customer customer) {

        if(customerbo != null) {
            if(customerbo.getCustomerId() != null) {
                customer.setCustomerId(customerbo.getCustomerId());
            }
            if(StringUtils.isNotBlank(customerbo.getFirstName())) {
                customer.setFirstName(customerbo.getFirstName());
            }
            if(StringUtils.isNotBlank(customerbo.getLastName())) {
                customer.setLastName(customerbo.getLastName());
            }
            if(StringUtils.isNotBlank(customerbo.getEmailId())) {
                customer.setEmailId(customerbo.getEmailId());
            }
            if(StringUtils.isNotBlank(customerbo.getPhoneNumber())) {
                customer.setPhoneNumber(customerbo.getPhoneNumber());
            }
        }

        return customer;
    }


    public static CustomerBO transformCustomerTOCustomerBO(Customer customer, CustomerBO customerBO) {

        if(customer != null) {
            if(customer.getCustomerId() != null) {
                customerBO.setCustomerId(customer.getCustomerId());
            }
            if(StringUtils.isNotBlank(customer.getFirstName())) {
                customerBO.setFirstName(customer.getFirstName());
            }
            if(StringUtils.isNotBlank(customer.getLastName())) {
                customerBO.setLastName(customer.getLastName());
            }
            if(StringUtils.isNotBlank(customer.getEmailId())) {
                customerBO.setEmailId(customer.getEmailId());
            }
            if(StringUtils.isNotBlank(customer.getPhoneNumber())) {
                customerBO.setPhoneNumber(customer.getPhoneNumber());
            }
        }

        return customerBO;
    }


}
