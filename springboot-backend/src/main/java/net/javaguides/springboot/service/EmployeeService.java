package net.javaguides.springboot.service;

 
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springboot.Kafka.KafkaOutboundService;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.Kafka.KafkaTopicsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private KafkaOutboundService kafkaOutboundService;

    @Autowired
    private KafkaTopicsConfig kafkaTopicsConfig;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Employee createEmployee(Employee employee) throws Exception {
        Employee savedEmployee = employeeRepository.save(employee);
        String employeeJson = objectMapper.writeValueAsString(savedEmployee);
        kafkaOutboundService.sendMessage(kafkaTopicsConfig.getEmployeeAdd(), null, employeeJson);
        return savedEmployee;
    }

    public Employee updateEmployee(Long id, Employee updatedData) throws Exception {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not exist with id: " + id));
        
        employee.setFirstName(updatedData.getFirstName());
        employee.setLastName(updatedData.getLastName());
        employee.setEmailId(updatedData.getEmailId());

        Employee updatedEmployee = employeeRepository.save(employee);
        String employeeJson = objectMapper.writeValueAsString(updatedEmployee);
        kafkaOutboundService.sendMessage(kafkaTopicsConfig.getEmployeeUpdate(), null, employeeJson);
        return updatedEmployee;
    }
}
