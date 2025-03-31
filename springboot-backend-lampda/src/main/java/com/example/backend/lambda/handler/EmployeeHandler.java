package com.example.backend.lambda.handler;
 
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

        // Update the database
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String updateQuery = "UPDATE employees SET first_name = ?, last_name = ? WHERE email_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
                statement.setString(1, firstName);
                statement.setString(2, lastName);
                statement.setString(3, emailId);
                
                int rowsUpdated = statement.executeUpdate();

                if (rowsUpdated > 0) {
                    return "Employee updated successfully: " + firstName + " " + lastName;
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
