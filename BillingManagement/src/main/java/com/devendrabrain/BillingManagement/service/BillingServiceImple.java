package com.devendrabrain.BillingManagement.service;

import com.devendrabrain.BillingManagement.bo.BillingBO;
import com.devendrabrain.BillingManagement.dao.BillIngDAO;
import com.devendrabrain.BillingManagement.entity.Billing;
import com.devendrabrain.BillingManagement.transformer.BillingTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceImple implements BillingService{

    @Autowired
    BillIngDAO billIngDAO;

    @Override
    public BillingBO fetchById(BillingBO billingBO) {
        //Validate inputs

        //Fetch call
        Billing billing = billIngDAO.fetchById(billingBO.getCustomerId(), billingBO.getOrderId());

        // Tranform
        BillingBO responseObj = BillingTranformer.tranformBillingToBillingBO(billing,billingBO);
        return responseObj;
    }

    @Override
    public BillingBO process(BillingBO billingBO) {

        //Validate inputs

        //Tranform
        Billing billing = BillingTranformer.tranformBillingBOToBilling(billingBO, new Billing());

        //save call
        billing = billIngDAO.process(billing);

        //Transform
        billingBO = BillingTranformer.tranformBillingToBillingBO(billing,billingBO);

        return billingBO;
    }
}
