package net.javaguides.springboot.Kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springboot.model.Employees;
import net.javaguides.springboot.repository.EmployeeElasticRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaInboundService {

    @Autowired
    private EmployeeElasticRepository employeeElasticRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "${kafka.topic.employee-add}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeAndSave(String message) {
        try {
            Employees employee = objectMapper.readValue(message, Employees.class);
            employeeElasticRepository.save(employee);
            System.out.println("✅ Inserted into Elastic: " + employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




