package com.example.backend.lambda.handler;
 
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class EmployeeHandler implements RequestHandler<Map<String, String>, String> {
    
    // Database connection details
    private static final String DB_URL = "jdbc:postgresql://database-1.cy34wwy06ef1.us-east-1.rds.amazonaws.com:5432/database-1";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Thiruna123"; 

    @Override
    public String handleRequest(Map<String, String> input, Context context) {
        String firstName = input.get("firstName");
        String lastName = input.get("lastName");
        String emailId = input.get("emailId");

        System.out.println("Received Employee Data: " + firstName + ", " + lastName + ", " + emailId);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Step 1: Check if employee exists
            String checkQuery = "SELECT COUNT(*) FROM employees WHERE email_id = ?";
            try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
                checkStmt.setString(1, emailId);
                ResultSet resultSet = checkStmt.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    // Employee exists, proceed with update
                    String updateQuery = "UPDATE employees SET first_name = ?, last_name = ? WHERE email_id = ?";
                    try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
                        updateStmt.setString(1, firstName);
                        updateStmt.setString(2, lastName);
                        updateStmt.setString(3, emailId);

                        int rowsUpdated = updateStmt.executeUpdate();
                        return "Employee updated successfully: " + firstName + " " + lastName;
                    }
                } else {
                    return "No employee found with email: " + emailId;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }
}
