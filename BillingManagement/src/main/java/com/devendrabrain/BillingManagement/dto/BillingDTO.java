package com.devendrabrain.BillingManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.Date;

@Data
@JsonPropertyOrder({"BillingId","CustomerId","InventoryId","OrderId","TotalBillingAmount", "OrderDate"})
public class BillingDTO {

    @JsonProperty("BillingId")
    private Long billingId;
    @JsonProperty("CustomerId")
    private Long customerId;
    @JsonProperty("InventoryId")
    private Long inventoryId;
    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("TotalBillingAmount")
    private Long totalBillingAmount;
    @JsonProperty("OrderDate")
    private Date orderDate;
}
