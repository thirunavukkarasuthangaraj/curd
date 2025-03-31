package com.example.lambda.handler;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambda.config.AppConfig;
import com.example.lambda.model.Employee;
import com.example.lambda.repository.EmployeeRepository;
public class EmployeeLambdaHandler implements RequestHandler<Map<String, String>, String> {

    private ApplicationContext context;
    private EmployeeRepository employeeRepository;

    public EmployeeLambdaHandler() {
        // Initialize Spring context inside constructor
        this.context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.employeeRepository = context.getBean(EmployeeRepository.class);
    }

    @Override
    public String handleRequest(Map<String, String> input, Context lambdaContext) {
        try {
            Employee employee = new Employee();
            employee.setFirstName(input.get("firstName"));
            employee.setLastName(input.get("lastName"));
            employee.setEmailId(input.get("emailId"));

            employeeRepository.save(employee);  // Save in PostgreSQL

            return "Employee " + employee.getFirstName() + " saved successfully!";
        } catch (Exception e) {
            return "Error saving employee: " + e.getMessage();
        }
    }
}
