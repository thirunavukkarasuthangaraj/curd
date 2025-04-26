package net.javaguides.springboot.Kafka; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaProducer {

    @Autowired
    private KafkaChannels kafkaChannels;

    public void sendAddEmployeeMessage(String message) {
        kafkaChannels.employeeAddOutput().send(MessageBuilder.withPayload(message).build());
    }

    public void sendUpdateEmployeeMessage(String message) {
        kafkaChannels.employeeUpdateOutput().send(MessageBuilder.withPayload(message).build());
    }
}
