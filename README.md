# 📁 Subscription Manager

## 📝 Description

This is a Java application for managing users and subscriptions. It applies **Domain-Driven Design (DDD)**, **REST API**, and **database handling**. The application allows user registration, authentication, and subscription management.

## 🌟 Features

### 👤 Users:
- Register new users
- Authenticate using email and password
- Update and delete user data

### 📄 Subscriptions:
- Register subscriptions linked to users
- Update and delete subscriptions

### 🌐 REST API:
- Endpoints for all CRUD operations
- CORS configuration to allow external requests

### 💾 Database:
- Data persistence using **Oracle SQL**
- Relationships between **Users** and **Subscriptions** tables

## 🛠 Technologies Used

- **Language:** Java  
- **Frameworks/Libraries:**  
  - Jersey (for REST API)  
  - Grizzly (HTTP server)  
- **Database:** Oracle SQL  
- **Patterns & Architecture:** Domain-Driven Design (DDD)  

## 🚀 Project Setup

1. **Clone the repository:**
   ```sh
   git clone https://github.com/SouzaEu/JavaSubManager.git

2. **Install dependencies:**
   ```sh
   mvn install

3. **Set up the database:**
   
   Create the tables in Oracle using the relational diagram provided in the project.
   Configure the database credentials in the ConnectionFactory file.

4. **Run the server:**
   Compile the project and start the HTTP server using the Main class.



## 📂 Package Structure

- **`br.com.fiap.bo`**: Contains the business logic of the system, such as validations and interactions between DAO and resources.
- **`br.com.fiap.dao`**: Handles communication with the database.
- **`br.com.fiap.model`**: Classes representing the system entities (e.g., `User` and `Subscription`).
- **`br.com.fiap.resource`**: Endpoints exposed via REST API.
- **`br.com.fiap.util`**: Utilities, such as database connection and filters.


   
