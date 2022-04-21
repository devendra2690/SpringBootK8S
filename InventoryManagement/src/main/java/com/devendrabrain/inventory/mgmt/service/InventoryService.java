package com.devendrabrain.inventory.mgmt.service;


import com.devendrabrain.inventory.mgmt.bo.InventoryBO;

import java.util.List;

public interface InventoryService {

     List<InventoryBO> fetchAll();
     InventoryBO fetchById(Long id);
     InventoryBO create(InventoryBO inventoryBO);
     void delete(Long id);
}
