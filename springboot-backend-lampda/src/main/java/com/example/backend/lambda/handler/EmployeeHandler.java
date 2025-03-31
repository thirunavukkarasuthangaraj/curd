package com.example.backend.lambda.handler;
 
 
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
 
public class EmployeeHandler implements RequestHandler<String, String> {
    @Override
    public String handleRequest(String input, Context context) {
        return "Hello, " + input + "! This is from AWS Lambda.";
    }
}