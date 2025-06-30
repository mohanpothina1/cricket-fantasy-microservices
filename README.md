🏏 Cricket Fantasy Microservices 🎯

A microservices-based Cricket Fantasy App built using:

- Java & Spring Boot
- Kafka for messaging
- MongoDB & MySQL for storage
- Docker for containerization
- JUnit & Lombok for testing and boilerplate handling

🧩 Microservices Overview
 --------------------------------------------------------------------------------------------------------------------
| Service            | Tech Used       | Description                                                                 |
| ------------------ | --------------- | --------------------------------------------------------------------------- |
| **User Service**   | MySQL           | Manages user registration, authentication, and profile details              |
| **Player Service** | MongoDB         | Stores player statistics and information                                    |
| **Match Service**  | MySQL           | Handles live match events, scores, and match updates                        |
| **Team-Builder**   | MongoDB         | Enables users to create fantasy teams using real-time player and match data |
| **Score Service**  | Kafka + MongoDB | Publishes and updates live scores, consumed by relevant services            |
| **Notification**   | Kafka           | Sends notifications for score updates and match alerts to users             |
| **API Gateway**    | Spring Boot     | Acts as a single entry point for routing requests to respective services    |
 --------------------------------------------------------------------------------------------------------------------

📦 Running Locally

1. Clone the repo:
   
    git clone https://github.com/mohanpothina1/cricket-fantasy-microservices.git
    cd cricket-fantasy-microservices
   
2. Start Docker containers for databases (MySQL, MongoDB, Kafka).

3. Run each service individually using:
   
      mvn spring-boot:run

