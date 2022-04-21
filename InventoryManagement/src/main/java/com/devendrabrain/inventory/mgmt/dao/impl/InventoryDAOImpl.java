package com.devendrabrain.inventory.mgmt.dao.impl;

import com.devendrabrain.inventory.mgmt.dao.InventoryDAO;
import com.devendrabrain.inventory.mgmt.entity.Inventory;
import com.devendrabrain.inventory.mgmt.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> fetchAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory fetchById(Long id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventory create(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Long id) {
        inventoryRepository.deleteById(id);
    }
}
