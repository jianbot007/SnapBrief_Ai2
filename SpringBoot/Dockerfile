# Use official Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Create folder inside container
WORKDIR /app

# Copy jar file from target folder
COPY target/*.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
