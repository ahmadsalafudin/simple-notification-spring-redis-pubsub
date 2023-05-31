package com.filkod.spring.notification.redis.pubsub.message;

import com.filkod.spring.notification.redis.pubsub.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderMessagePublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic topic;

    public void publish(String message){
        this.redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
