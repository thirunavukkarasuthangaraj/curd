# Use OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy backend jar
COPY backend.jar app.jar

# Expose port
EXPOSE 8080 

# Start application
ENTRYPOINT ["java", "-jar", "app.jar"]
