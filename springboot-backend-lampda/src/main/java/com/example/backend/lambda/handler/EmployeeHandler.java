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
            if (employeeExists(connection, emailId)) {
                return updateEmployee(connection, firstName, lastName, emailId);
            } else {
                return insertEmployee(connection, firstName, lastName, emailId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Database error: " + e.getMessage();
        }
    }

    // Method to check if the employee exists in the database
    private boolean employeeExists(Connection connection, String emailId) throws Exception {
        String checkQuery = "SELECT COUNT(*) FROM employees WHERE email_id = ?";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setString(1, emailId);
            ResultSet resultSet = checkStmt.executeQuery();
            return resultSet.next() && resultSet.getInt(1) > 0;
        }
    }

    // Method to insert a new employee
    private String insertEmployee(Connection connection, String firstName, String lastName, String emailId) throws Exception {
        String insertQuery = "INSERT INTO employees (first_name, last_name, email_id) VALUES (?, ?, ?)";
        try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
            insertStmt.setString(1, firstName);
            insertStmt.setString(2, lastName);
            insertStmt.setString(3, emailId);
            insertStmt.executeUpdate();
            return "New employee inserted: " + firstName + " " + lastName;
        }
    }

    // Method to update an existing employee
    private String updateEmployee(Connection connection, String firstName, String lastName, String emailId) throws Exception {
        String updateQuery = "UPDATE employees SET first_name = ?, last_name = ? WHERE email_id = ?";
        try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {
            updateStmt.setString(1, firstName);
            updateStmt.setString(2, lastName);
            updateStmt.setString(3, emailId);
            int rowsUpdated = updateStmt.executeUpdate();
            return "Employee updated successfully: " + firstName + " " + lastName;
        }
    }
}