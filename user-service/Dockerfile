# Step 1: Use base image with Java 17
FROM openjdk:17-jdk-slim

# Step 2: Set working directory
WORKDIR /app

# Step 3: Copy the JAR file
COPY target/user-service.jar app.jar

# Step 4: Run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
