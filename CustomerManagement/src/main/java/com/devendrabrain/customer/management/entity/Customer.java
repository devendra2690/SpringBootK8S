package com.devendrabrain.customer.management.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name ="customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "phone_number")
    private String phoneNumber;
    @OneToOne(mappedBy = "customer")
    private UserAuth userAuth;
}
