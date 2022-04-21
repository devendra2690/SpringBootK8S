package com.devendrabrain.OrderManagement.util.billing;

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

    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTotalBillingAmount() {
        return totalBillingAmount;
    }

    public void setTotalBillingAmount(Long totalBillingAmount) {
        this.totalBillingAmount = totalBillingAmount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
