package com.devendrabrain.BillingManagement.dao;

import com.devendrabrain.BillingManagement.entity.Billing;

public interface BillIngDAO {

    Billing fetchById(Long customerId, Long orderId);
    Billing process(Billing billing);
}
