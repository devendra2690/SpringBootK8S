package com.devendrabrain.inventory.mgmt.dao;


import com.devendrabrain.inventory.mgmt.entity.Inventory;

import java.util.List;

public interface InventoryDAO {

    List<Inventory> fetchAll();
    Inventory fetchById(Long id);
    Inventory create(Inventory inventory);
    void delete(Long id);
}
