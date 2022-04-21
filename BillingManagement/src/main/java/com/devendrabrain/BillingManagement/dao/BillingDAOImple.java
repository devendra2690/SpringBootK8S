package com.devendrabrain.BillingManagement.dao;

import com.devendrabrain.BillingManagement.repository.BillingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.devendrabrain.BillingManagement.entity.Billing;

@Repository
public class BillingDAOImple implements BillIngDAO{

    @Autowired
    BillingRepo billingRepo;

    @Override
    public Billing fetchById(Long customerId, Long orderId) {
        return billingRepo.fetchByCustomerIdAndOrderId(customerId,orderId);
    }

    @Override
    public Billing process(Billing billing) {
        return billingRepo.save(billing);
    }
}
