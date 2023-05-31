package com.filkod.spring.notification.redis.pubsub.repository;

import com.filkod.spring.notification.redis.pubsub.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findOrderByTransactionId(String transactionId);
}
