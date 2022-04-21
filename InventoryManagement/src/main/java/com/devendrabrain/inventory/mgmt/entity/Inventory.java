package com.devendrabrain.inventory.mgmt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
    @Column(name = "inventory_name")
    private String inventoryName;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "price")
    private Long price;
}
