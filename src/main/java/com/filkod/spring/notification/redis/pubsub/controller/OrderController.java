package com.filkod.spring.notification.redis.pubsub.controller;

import com.filkod.spring.notification.redis.pubsub.dto.OrderRequest;
import com.filkod.spring.notification.redis.pubsub.dto.Response;
import com.filkod.spring.notification.redis.pubsub.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Response createOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.doInsertOrder(orderRequest);
    }

    @GetMapping("/{id}")
    public Response checkStatus(@PathVariable("id") String transactionId) {
        return orderService.doCheckStatus(transactionId);
    }
}
