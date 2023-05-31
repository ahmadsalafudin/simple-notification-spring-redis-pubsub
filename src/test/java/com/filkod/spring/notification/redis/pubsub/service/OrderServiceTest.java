package com.filkod.spring.notification.redis.pubsub.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filkod.spring.notification.redis.pubsub.dto.OrderRequest;
import com.filkod.spring.notification.redis.pubsub.dto.Response;
import com.filkod.spring.notification.redis.pubsub.message.OrderMessagePublisher;
import com.filkod.spring.notification.redis.pubsub.model.Order;
import com.filkod.spring.notification.redis.pubsub.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class OrderServiceTest {
    @Value("${courier.type}")
    String courierType;
    @InjectMocks
    OrderService orderService;
    @Mock
    OrderMessagePublisher messagePublisher;
    @Mock
    OrderRepository orderRepository;
    @Mock
    ObjectMapper objectMapper;
    OrderRequest orderRequest = new OrderRequest();
    private final static String SUCCESS = "Success";
    private final static String ERROR = "Error";

    @BeforeEach
    void setUp() {
        orderRequest.setTransactionId("ORD12345");
        orderRequest.setProductName("Play Station 5");
        orderRequest.setProductQty(2);
        orderRequest.setProductPrice(2500000);
        orderRequest.setBuyerName("Ahmad Salafudin");
        orderRequest.setBuyerEmail("ahmadsalafudin@gmail.com");
        orderRequest.setBuyerPhoneNumber("628923432334");
    }

    @Test
    void testCreateOrderSuccess() {
        when(orderRepository.findOrderByTransactionId(anyString())).thenReturn(Optional.empty());

        Response order = orderService.doInsertOrder(orderRequest);
        assertThat(order).isNotNull();
        assertThat(order.getStatus()).isEqualTo(SUCCESS);
        verify(messagePublisher, times(1)).publish(orderRequest.toString());
        verify(orderRepository, times(1)).save(new Order());
    }
}
