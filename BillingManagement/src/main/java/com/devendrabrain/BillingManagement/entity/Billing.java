package com.devendrabrain.BillingManagement.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingId;

    @Column
    private Long customerId;

    @Column
    private Long inventoryId;

    @Column
    private Long orderId;

    @Column
    private Long totalBillingAmount;

    @Column
    private Date orderDate;
}
