package com.devendrabrain.inventory.mgmt.bo;

import lombok.Data;

@Data
public class InventoryBO {

    private Long inventoryId;
    private String inventoryName;
    private Long quantity;
    private Long price;
}
