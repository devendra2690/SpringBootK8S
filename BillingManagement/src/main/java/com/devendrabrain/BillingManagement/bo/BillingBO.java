package com.devendrabrain.BillingManagement.bo;

import lombok.Data;

import java.util.Date;

@Data
public class BillingBO {

    private Long billingId;
    private Long customerId;
    private Long inventoryId;
    private Long orderId;
    private Long totalBillingAmount;
    private Date orderDate;
}
