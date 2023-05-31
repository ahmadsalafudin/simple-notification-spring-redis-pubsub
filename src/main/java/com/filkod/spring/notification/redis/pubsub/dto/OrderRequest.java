package com.filkod.spring.notification.redis.pubsub.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    @NotEmpty(message = "Transaction ID cannot be null or empty")
    private String transactionId;
    @NotEmpty(message = "Product name cannot be null or empty")
    private String productName;
    @NotEmpty(message = "Product qty cannot be null or empty")
    private int productQty;
    @NotEmpty(message = "Product price cannot be null or empty")
    private int productPrice;
    @NotEmpty(message = "Buyer name cannot be null or empty")
    private String buyerName;
    @NotEmpty(message = "Buyer phone cannot be null or empty")
    private String buyerPhoneNumber;
    @NotEmpty(message = "Buyer email cannot be null or empty")
    private String buyerEmail;
}
