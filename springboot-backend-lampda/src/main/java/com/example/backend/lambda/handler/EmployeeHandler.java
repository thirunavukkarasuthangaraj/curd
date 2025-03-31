package com.example.backend.lambda.handler;
 
 
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.util.Map;

public class EmployeeHandler implements RequestHandler<Map<String, String>, String> {
    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        System.out.println("Received input: " + input); // Log the input to CloudWatch

        // Extract data 
        String firstName = input.get("firstName");
        String lastName = input.get("lastName");
        String emailId = input.get("emailId");

        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email ID: " + emailId);

        return "Employee details received: " + firstName + " " + lastName + " (" + emailId + ")";
    }
}


