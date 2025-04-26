package net.javaguides.springboot.Kafka;
 

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaChannels {

    String EMPLOYEE_ADD_OUTPUT = "employeeAddOutput";
    String EMPLOYEE_UPDATE_OUTPUT = "employeeUpdateOutput";
    String EMPLOYEE_ADD_INPUT = "employeeAddInput";
    String EMPLOYEE_UPDATE_INPUT = "employeeUpdateInput";

    @Output(EMPLOYEE_ADD_OUTPUT)
    MessageChannel employeeAddOutput();

    @Output(EMPLOYEE_UPDATE_OUTPUT)
    MessageChannel employeeUpdateOutput();

    @Input(EMPLOYEE_ADD_INPUT)
    SubscribableChannel employeeAddInput();

    @Input(EMPLOYEE_UPDATE_INPUT)
    SubscribableChannel employeeUpdateInput();
}
