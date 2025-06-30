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
   
🖼️ Demo Screenshots

![image](https://github.com/user-attachments/assets/758b41b5-137c-403a-bd95-070465dccd74)
![image](https://github.com/user-attachments/assets/c25a4214-5db4-49b1-b7a9-d74a3230c091)
![image](https://github.com/user-attachments/assets/86cb1e9e-0b06-45d5-a8f7-1ace5bb40bf1)
![image](https://github.com/user-attachments/assets/db9c0834-7a5e-41a7-b4aa-f649d3c05685)
![image](https://github.com/user-attachments/assets/cd6fde4a-ee65-4c6a-9076-fdd531f11eb8)




