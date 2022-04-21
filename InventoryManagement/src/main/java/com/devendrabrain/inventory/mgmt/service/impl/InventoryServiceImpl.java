package com.devendrabrain.inventory.mgmt.service.impl;

import com.devendrabrain.inventory.mgmt.bo.InventoryBO;
import com.devendrabrain.inventory.mgmt.dao.InventoryDAO;
import com.devendrabrain.inventory.mgmt.entity.Inventory;
import com.devendrabrain.inventory.mgmt.service.InventoryService;
import com.devendrabrain.inventory.mgmt.transformer.InventoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    InventoryDAO inventoryDAO;

    @Override
    public List<InventoryBO> fetchAll() {

        //Fetch All record
        List<Inventory> inventoryList = inventoryDAO.fetchAll();

        //Transform
        List<InventoryBO> inventoryBOList = new ArrayList<>();
        for(Inventory inventory : inventoryList) {

            InventoryBO inventoryBO = new InventoryBO();
            InventoryTransformer.transformInventoryTOInventoryBO(inventory,inventoryBO);
            inventoryBOList.add(inventoryBO);
        }

        return inventoryBOList;
    }

    @Override
    public InventoryBO fetchById(Long id) {

        // Validate Inputs

        //Fetch Call
        Inventory inventory = inventoryDAO.fetchById(id);

        //Transform
        InventoryBO inventoryBO = InventoryTransformer.transformInventoryTOInventoryBO(inventory,new InventoryBO());

        return inventoryBO;
    }

    @Override
    public InventoryBO create(InventoryBO inventoryBO) {
        // Validate Inputs

        // Tranform
        Inventory inventory = InventoryTransformer.transformInventoryBOTOInventory(inventoryBO, new Inventory());

        //Fetch Call
        inventoryDAO.create(inventory);

        //Tranform
        InventoryTransformer.transformInventoryTOInventoryBO(inventory,inventoryBO);

        return inventoryBO;
    }

    @Override
    public void delete(Long id) {

        // Validate Inputs

        // delete call
        inventoryDAO.delete(id);
    }
}
