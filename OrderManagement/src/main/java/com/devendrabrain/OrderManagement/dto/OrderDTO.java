package com.devendrabrain.OrderManagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonPropertyOrder({"OrderId","CustomerId","OrderDate","OrderDetails","TotalOrderAmount"})
public class OrderDTO {

    @JsonProperty("OrderId")
    private Long orderId;
    @JsonProperty("CustomerId")
    private Long customerId;
    @JsonProperty("OrderDate")
    private Date orderDate;
    @JsonProperty("OrderDetails")
    private List<OrderDetails> orderDetails = new ArrayList<>();
    @JsonProperty("TotalOrderAmount")
    private Long totalOrderAmount;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(Long totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    @Data
    @JsonPropertyOrder({"InventoryId","Quantity","TotalPrice"})
    public static class OrderDetails {

        @JsonProperty("InventoryId")
        private Long inventoryId;
        @JsonProperty("Quantity")
        private Long quantity;
        @JsonProperty("TotalPrice")
        private Long totalPrice;

        public Long getInventoryId() {
            return inventoryId;
        }

        public void setInventoryId(Long inventoryId) {
            this.inventoryId = inventoryId;
        }

        public Long getQuantity() {
            return quantity;
        }

        public void setQuantity(Long quantity) {
            this.quantity = quantity;
        }

        public Long getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Long totalPrice) {
            this.totalPrice = totalPrice;
        }
    }
}
