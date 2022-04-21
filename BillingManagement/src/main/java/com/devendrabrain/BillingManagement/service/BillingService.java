package com.devendrabrain.BillingManagement.service;

import com.devendrabrain.BillingManagement.bo.BillingBO;

public interface BillingService {

    BillingBO fetchById(BillingBO billingBO);
    BillingBO process(BillingBO billingBO);
}
