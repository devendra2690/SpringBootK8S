package com.devendrabrain.inventory.mgmt.repository;

;
import com.devendrabrain.inventory.mgmt.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
