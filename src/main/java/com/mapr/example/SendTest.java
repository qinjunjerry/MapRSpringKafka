package com.mapr.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class SendTest {

    private static final Logger LOG = LoggerFactory.getLogger(SendTest.class);

    public static void main(String[] args) throws IOException {

        String topic = "/s1:t1";
         
        Properties producerProps = new Properties();
        producerProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        producerProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);) {
            for (int i = 0; i < 10; i++) {
                ProducerRecord<String, String> record = new ProducerRecord<>(topic, 
                    "Key" + i + ":" + new Date(), 
                    "Val" + i + ":" + new Date()
                );
                producer.send(record);
                System.out.println("Record sent: " + record);
            }
        }
    }
}
