FROM openjdk:17-jdk-slim

WORKDIR /app

# No renaming, copy original jar
COPY target/springboot-backend-0.0.1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
