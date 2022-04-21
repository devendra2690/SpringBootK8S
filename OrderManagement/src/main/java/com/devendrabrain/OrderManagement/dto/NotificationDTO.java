package com.devendrabrain.OrderManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@JsonPropertyOrder({"CustomerId","OrderId","TotalPrice","InventoryDetails","CustomerEmail","CustomerFirstName","CustomerLastName"})
public class NotificationDTO {

    @JsonProperty("CustomerId")
    private Long customerId;
    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("TotalPrice")
    private Long totalPrice;
    @JsonProperty("InventoryDetails")
    private Map<Long, String> inventoryDetails = new HashMap<>();
    @JsonProperty("CustomerEmail")
    private String email;
    @JsonProperty("CustomerFirstName")
    private String customerFirstName;
    @JsonProperty("CustomerLastName")
    private String customerLastName;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Map<Long, String> getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(Map<Long, String> inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }
}
