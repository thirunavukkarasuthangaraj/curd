package com.thiru.kafka.learn.kafka.consumer;

 
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "topic.employee.add", groupId = "my-group")
    public void listenAddEmployee(String message) {
        System.out.println("📥 Received from ADD topic: " + message);
    }

    @KafkaListener(topics = "topic.employee.update", groupId = "my-group")
    public void listenUpdateEmployee(String message) {
        System.out.println("📥 Received from UPDATE topic: " + message);
    }
}

