package com.filkod.spring.notification.redis.pubsub.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "orders")
@Setter
@Getter
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String transactionId;
    private String productName;
    private int productQty;
    private int productPrice;
    private String buyerName;
    private String buyerPhoneNumber;
    private String buyerEmail;
    private String state;
}
