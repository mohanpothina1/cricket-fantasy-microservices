# Step 1: Use a base image with Java
FROM openjdk:17-jdk-slim

# Step 2: Set working directory inside container
WORKDIR /app

# Step 3: Copy the packaged jar file to the container
COPY target/player-service.jar app.jar

# Step 4: Set the command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
