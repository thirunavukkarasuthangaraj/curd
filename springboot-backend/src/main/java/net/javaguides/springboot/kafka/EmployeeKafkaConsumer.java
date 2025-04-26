package net.javaguides.springboot.Kafka;
 
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class EmployeeKafkaConsumer {

    @StreamListener(KafkaChannels.EMPLOYEE_ADD_INPUT)
    public void handleAddEmployee(String message) {
        System.out.println("📥 Received from ADD topic: " + message);
    }

    @StreamListener(KafkaChannels.EMPLOYEE_UPDATE_INPUT)
    public void handleUpdateEmployee(String message) {
        System.out.println("📥 Received from UPDATE topic: " + message);
    }
}
