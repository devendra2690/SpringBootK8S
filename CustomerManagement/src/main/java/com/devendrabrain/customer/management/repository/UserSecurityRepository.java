package com.devendrabrain.customer.management.repository;

import com.devendrabrain.customer.management.entity.UserAuth;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserSecurityRepository extends JpaRepository<UserAuth,Long> {

    @Query(value = "select * from [InventoryMgr].[dbo].[user_auth] where username=:username",nativeQuery = true)
    public UserAuth findByUsername(@Param("username") String username);
}
