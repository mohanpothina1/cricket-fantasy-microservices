# 🏏 Cricket Fantasy Microservices 🎯

A microservices-based Cricket Fantasy App built using:

- Java & Spring Boot
- Kafka for messaging
- MongoDB & MySQL for storage
- Docker for containerization
- JUnit & Lombok for testing and boilerplate handling

## 🧩 Microservices Overview
 
 This app is made up of several microservices, each responsible for a specific part of the fantasy cricket platform. Here is a detailed overview of the key REST APIs for each service and what they do.

---
### 👤 User Service
**Handles:** User registration, login, and profile management.  
**Base URL:** `/api/users`

| Method | Endpoint         | Description                                      |
|--------|------------------|--------------------------------------------------|
| POST   | `/register`      | Register a new user account                      |
| POST   | `/login`         | Authenticate a user and return login details     |
| GET    | `/profile/{id}`  | Fetch the profile of a specific user by their ID |

**🔍 Example**

To register a new user:

**Request**
```http
POST /api/users/register
Content-Type: application/json

{
  "username": "xyz",
  "email": "abc@example.com",
  "password": "securepassword123"
}
```

---

### 🏏 Player Service
**Handles:** CRUD operations for cricket players and their stats.  
**Base URL:** `/api/players`

| Method | Endpoint     | Description                                |
|--------|--------------|--------------------------------------------|
| GET    | `/`          | List all available players and their stats |
| GET    | `/{id}`      | Get full details of a specific player      |
| POST   | `/`          | Add a new player to the system             |

**🔍 Example**

To add a new cricket player with their stats:

**Request**

```http
POST /api/players
Content-Type: application/json

{
  "name": "Virat Kohli",
  "team": "India",
  "role": "Batsman",
  "average": 56.72
}
```

---

### 🏟️ Match Service
**Handles:** Match scheduling, updates, and live match data.  
**Base URL:** `/api/matches`

| Method | Endpoint     | Description                              |
|--------|--------------|------------------------------------------|
| GET    | `/`          | List all scheduled or ongoing matches    |
| GET    | `/{id}`      | Get details of a particular match        |
| POST   | `/`          | Schedule a new cricket match             |

**🔍 Example**

To schedule a new cricket match:

**Request**

```http
POST /api/matches
Content-Type: application/json

{
  "teamA": "India",
  "teamB": "Australia",
  "matchDate": "2025-08-15T14:30:00Z",
  "venue": "Wankhede Stadium",
  "matchType": "ODI"
}
```

---

### 🧩 Team Builder Service
**Handles:** Creating fantasy teams using real players and matches.  
**Base URL:** `/api/teams`

| Method | Endpoint         | Description                                 |
|--------|------------------|---------------------------------------------|
| POST   | `/`              | Create a fantasy team with selected players |
| GET    | `/user/{userId}` | List all teams created by a specific user   |

**🔍 Example**

To create a fantasy team for a user with selected players:

**Request**

```http
POST /api/teams
Content-Type: application/json

{
  "userId": "64b2f1b7d97efb3450d5e234",
  "teamName": "PowerHitters",
  "playerIds": [
    "player123", "player456", "player789"
  ],
  "captainId": "player123"
}
```
---
### 📊 Score Service
**Handles:** Real-time score updates.  
**Notes:**
- Publishes live scores to Kafka topic: `score-updates`
- These updates are consumed by other services like Notification and Team Builder to keep everything in sync.

**🔍 Example**

To send live score update for a match:

**Request**

```http
POST /api/scores
Content-Type: application/json

{
  "matchId": "match987",
  "score": "India 256/4 (42.3)",
  "timestamp": "2025-08-15T15:45:00Z"
}
```
---

### 🔔 Notification Service
**Handles:** Sending alerts and notifications to users.  
**Notes:**
- Subscribes to Kafka topic: `notifications`
- Sends updates for score changes, match events, or custom alerts to users via in-app or push mechanisms.

**🔍 Example**

To manually trigger a notification for a user:

**Request**

```http
POST /api/notifications
Content-Type: application/json

{
  "userId": "64b2f1b7d97efb3450d5e234",
  "type": "SCORE_UPDATE",
  "message": "India has scored 250+ runs!",
  "timestamp": "2025-08-15T15:46:00Z"
}
```
---

### 🚪 API Gateway
**Handles:** Acts as a single entry point for routing requests to respective services  
**Base URL:** `/api`

| Method | Example Endpoint       | Description                                |
|--------|------------------------|--------------------------------------------|
| GET    | `/users/profile/{id}` | Routes request to User Service             |
| GET    | `/players`            | Routes request to Player Service           |
| GET    | `/matches`            | Routes request to Match Service            |
| POST   | `/teams`              | Routes request to Team Builder Service     |

**🔍 Example**

To route the request to the Player Service securely:

**Request**

```http
GET /api/players
Authorization: Bearer <your_token_here>
```
---

## 📦 Running Locally

1. Clone the repo:
   
    git clone https://github.com/mohanpothina1/cricket-fantasy-microservices.git
    cd cricket-fantasy-microservices
   
2. Start Docker containers for databases (MySQL, MongoDB, Kafka).

3. Run each service individually using:
   
      mvn spring-boot:run



## 🖼️ Demo Screenshots

![image](https://github.com/user-attachments/assets/758b41b5-137c-403a-bd95-070465dccd74)
![image](https://github.com/user-attachments/assets/c25a4214-5db4-49b1-b7a9-d74a3230c091)
![image](https://github.com/user-attachments/assets/86cb1e9e-0b06-45d5-a8f7-1ace5bb40bf1)
![image](https://github.com/user-attachments/assets/db9c0834-7a5e-41a7-b4aa-f649d3c05685)
![image](https://github.com/user-attachments/assets/cd6fde4a-ee65-4c6a-9076-fdd531f11eb8)




