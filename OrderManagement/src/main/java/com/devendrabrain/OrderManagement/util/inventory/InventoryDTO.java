package com.devendrabrain.OrderManagement.util.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"InventoryId","InventoryName","Quantity","Price"})
public class InventoryDTO {

    @JsonProperty("InventoryId")
    private Long inventoryId;
    @JsonProperty("InventoryName")
    private String inventoryName;
    @JsonProperty("Quantity")
    private Long quantity;
    @JsonProperty("Price")
    private Long price;

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
