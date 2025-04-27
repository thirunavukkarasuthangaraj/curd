package net.javaguides.springboot.Kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "kafka.topic")
public class KafkaTopicsConfig {
    private String employeeAdd;
    private String employeeUpdate;

    public String getEmployeeAdd() { return employeeAdd; }
    public void setEmployeeAdd(String employeeAdd) { this.employeeAdd = employeeAdd; }

    public String getEmployeeUpdate() { return employeeUpdate; }
    public void setEmployeeUpdate(String employeeUpdate) { this.employeeUpdate = employeeUpdate; }
}
