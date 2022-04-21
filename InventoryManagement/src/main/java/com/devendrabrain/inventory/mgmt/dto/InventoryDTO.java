package com.devendrabrain.inventory.mgmt.dto;

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
}
