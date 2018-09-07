package com.mapr.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class KafkaSpring {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaSpring.class);

    public static final AtomicLong counter = new AtomicLong(1L);

    @KafkaListener(topics = "/s1:t1")
    public void listen(@Payload String message) {
        LOG.info("Received message {}: '{}'", counter.getAndIncrement(), message);
    }

}
