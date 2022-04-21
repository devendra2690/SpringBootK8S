package com.devendrabrain.customer.management.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @ElementCollection(targetClass=String.class,fetch = FetchType.EAGER)
    private List<String> authority;

    @OneToOne
    @JoinColumn(name = "cust_id")
    private Customer customer;
}
