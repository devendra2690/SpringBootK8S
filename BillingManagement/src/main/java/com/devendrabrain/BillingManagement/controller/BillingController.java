package com.devendrabrain.BillingManagement.controller;

import com.devendrabrain.BillingManagement.bo.BillingBO;
import com.devendrabrain.BillingManagement.constant.ApiName;
import com.devendrabrain.BillingManagement.dto.BillingDTO;
import com.devendrabrain.BillingManagement.service.BillingService;
import com.devendrabrain.BillingManagement.transformer.BillingTranformer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BillingMgr")
public class BillingController {

    @Autowired
    BillingService billingService;

    @GetMapping("/{customerId}/order/{orderId}")
    public BillingDTO fetchById(@PathVariable("customerId") Long customerId, @PathVariable("orderId") Long orderId) {

        MDC.put("X-RS-ApiName", ApiName.BILLING_MGR_FETCH_ALL_CUSTOMER_ID_ORDER_ID.name());


        // Call
        BillingBO billingRequestBO = new BillingBO();
        billingRequestBO.setCustomerId(customerId);
        billingRequestBO.setOrderId(orderId);

        BillingBO billingBO = billingService.fetchById(billingRequestBO);

        //Transform
        BillingDTO billingDTO = BillingTranformer.tranformBillingBOToBillingDTO(billingBO, new BillingDTO());

        return billingDTO;
    }

    @PostMapping("/process")
    public BillingDTO processBilling(@RequestBody BillingDTO billingDTO) {

        MDC.put("X-RS-ApiName", ApiName.BILLING_MGR_SAVE_BILLING_RECORD.name());


        /// Transform
        BillingBO billingBO = BillingTranformer.tranformBillingDTOToBillingBO(billingDTO, new BillingBO());

        //call
        billingBO = billingService.process(billingBO);

        //Transform
        billingDTO = BillingTranformer.tranformBillingBOToBillingDTO(billingBO, billingDTO);

        return billingDTO;
    }
}
