package com.example.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.lambda.model.Employee;
import com.example.lambda.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLambdaHandler implements RequestHandler<Employee, String> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public String handleRequest(Employee input, Context context) {
        employeeService.saveEmployee(input);
        return "Employee saved successfully!";
    }
}
