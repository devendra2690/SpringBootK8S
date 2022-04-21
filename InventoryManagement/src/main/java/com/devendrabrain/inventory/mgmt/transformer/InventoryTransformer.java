package com.devendrabrain.inventory.mgmt.transformer;


import com.devendrabrain.inventory.mgmt.bo.InventoryBO;
import com.devendrabrain.inventory.mgmt.dto.InventoryDTO;
import com.devendrabrain.inventory.mgmt.entity.Inventory;
import org.apache.commons.lang3.StringUtils;

public class InventoryTransformer {

    public static InventoryBO transformInventoryDTOTOInventoryBO(InventoryDTO inventoryDTO, InventoryBO inventoryBO) {

        if(inventoryDTO != null) {

            if(inventoryDTO.getInventoryId() != null) {
                inventoryBO.setInventoryId(inventoryDTO.getInventoryId());
            }
            if(StringUtils.isNotBlank(inventoryDTO.getInventoryName())) {
                inventoryBO.setInventoryName(inventoryDTO.getInventoryName());
            }
            if(inventoryDTO.getPrice() != null) {
                inventoryBO.setPrice(inventoryDTO.getPrice());
            }
            if(inventoryDTO.getQuantity() != null) {
                inventoryBO.setQuantity(inventoryDTO.getQuantity());
            }
        }

        return inventoryBO;
    }


    public static InventoryDTO transformInventoryBOTOInventoryDTO(InventoryBO inventoryBO, InventoryDTO inventoryDTO) {

        if(inventoryBO != null) {

            if(inventoryBO.getInventoryId() != null) {
                inventoryDTO.setInventoryId(inventoryBO.getInventoryId());
            }
            if(StringUtils.isNotBlank(inventoryBO.getInventoryName())) {
                inventoryDTO.setInventoryName(inventoryBO.getInventoryName());
            }
            if(inventoryBO.getPrice() != null) {
                inventoryDTO.setPrice(inventoryBO.getPrice());
            }
            if(inventoryBO.getQuantity() != null) {
                inventoryDTO.setQuantity(inventoryBO.getQuantity());
            }
        }

        return inventoryDTO;
    }


    public static InventoryBO transformInventoryTOInventoryBO(Inventory inventory, InventoryBO inventoryBO) {

        if(inventory != null) {

            if(inventory.getInventoryId() != null) {
                inventoryBO.setInventoryId(inventory.getInventoryId());
            }
            if(StringUtils.isNotBlank(inventory.getInventoryName())) {
                inventoryBO.setInventoryName(inventory.getInventoryName());
            }
            if(inventory.getPrice() != null) {
                inventoryBO.setPrice(inventory.getPrice());
            }
            if(inventory.getQuantity() != null) {
                inventoryBO.setQuantity(inventory.getQuantity());
            }
        }

        return inventoryBO;
    }


    public static Inventory transformInventoryBOTOInventory(InventoryBO inventoryBO, Inventory inventory) {

        if(inventoryBO != null) {

            if(inventoryBO.getInventoryId() != null) {
                inventory.setInventoryId(inventoryBO.getInventoryId());
            }
            if(StringUtils.isNotBlank(inventoryBO.getInventoryName())) {
                inventory.setInventoryName(inventoryBO.getInventoryName());
            }
            if(inventoryBO.getPrice() != null) {
                inventory.setPrice(inventoryBO.getPrice());
            }
            if(inventoryBO.getQuantity() != null) {
                inventory.setQuantity(inventoryBO.getQuantity());
            }
        }

        return inventory;
    }
}
