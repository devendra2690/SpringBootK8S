package com.devendrabrain.BillingManagement.repository;

import com.devendrabrain.BillingManagement.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillingRepo extends JpaRepository<Billing,Long> {

    @Query(value = "Select * from [InventoryMgr].[dbo].[billing] where customer_id=:customerId and order_id=:orderId",nativeQuery = true)
    public Billing fetchByCustomerIdAndOrderId(@Param("customerId") Long customerId, @Param("orderId") Long orderId);
}
