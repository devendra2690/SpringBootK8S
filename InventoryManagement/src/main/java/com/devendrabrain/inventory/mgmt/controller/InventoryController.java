package com.devendrabrain.inventory.mgmt.controller;

import com.devendrabrain.inventory.mgmt.bo.InventoryBO;
import com.devendrabrain.inventory.mgmt.constant.ApiName;
import com.devendrabrain.inventory.mgmt.dto.InventoryDTO;
import com.devendrabrain.inventory.mgmt.service.InventoryService;
import com.devendrabrain.inventory.mgmt.transformer.InventoryTransformer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/InventoryMgr")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/fetchAll")
    public List<InventoryDTO> fetchAll() {

        MDC.put("X-RS-ApiName", ApiName.IVT_MGR_FETCH_ALL_CUSTOMER_RECORD.name());

        //Fetch Data
        List<InventoryBO> inventoryBOList = inventoryService.fetchAll();

        //Transform
        List<InventoryDTO> inventoryDTOList = new ArrayList<>();

        for (InventoryBO inventoryBO : inventoryBOList) {
            InventoryDTO inventoryDTO = new InventoryDTO();
            InventoryTransformer.transformInventoryBOTOInventoryDTO(inventoryBO, inventoryDTO);
            inventoryDTOList.add(inventoryDTO);
        }

        return inventoryDTOList;
    }

    @GetMapping("/{id}")
    public InventoryDTO fetchById(@PathVariable("id") Long inventoryId) {
        MDC.put("X-RS-ApiName", ApiName.IVT_MGR_FETCH_BY_ID.name());

        InventoryBO inventoryBO = inventoryService.fetchById(inventoryId);

        //Transform
        InventoryDTO inventoryDTO = InventoryTransformer.transformInventoryBOTOInventoryDTO(inventoryBO,new InventoryDTO());

        return inventoryDTO;
    }

    @PostMapping("/create")
    public InventoryDTO create(@RequestBody InventoryDTO inventoryDTO) {
        MDC.put("X-RS-ApiName", ApiName.IVT_MGR_CREATE_INVENTORY_RECORD.name());

        // Transform DTO to BO
        InventoryBO inventoryBO = InventoryTransformer.transformInventoryDTOTOInventoryBO(inventoryDTO, new InventoryBO());
        inventoryBO = inventoryService.create(inventoryBO);

        //Transform BO TO DTO
        inventoryDTO = InventoryTransformer.transformInventoryBOTOInventoryDTO(inventoryBO,inventoryDTO);

        return inventoryDTO;
    }

    @DeleteMapping("/delete/{id}")
    public Map<String,Object> delete(@PathVariable("id") Long id) {
        MDC.put("X-RS-ApiName", ApiName.IVT_MGR_DELETE_INVENTORY_RECORD.name());

        inventoryService.delete(id);

        Map<String,Object> responeMap = new HashMap<>();
        responeMap.put("Message","Inventory record with ID "+id+" is deleted ..!!");

        return responeMap;
    }

}
