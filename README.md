# 📚 Library Management System (Spring Boot)

## 🚀 Overview
This project is a RESTful backend application built using Spring Boot.  
It provides APIs to manage books with secure authentication and role-based authorization.

---

## 🛠️ Tech Stack
- Java 11
- Spring Boot
- Spring Security
- JWT Authentication
- MySQL
- Spring Data JPA
- Lombok
- Swagger (OpenAPI)

---

## 🔐 Features
- CRUD operations for books
- JWT-based authentication
- Role-based authorization (ADMIN / USER)
- Password encryption using BCrypt
- Global exception handling
- Input validation using Jakarta Validation
- Standard API response structure
- Logging using SLF4J
- Swagger API documentation

---

## 🔄 API Endpoints

### Auth APIs
- POST /auth/register
- POST /auth/login

### Book APIs
- GET /books
- GET /books/{id}
- POST /books (ADMIN)
- PUT /books/{id} (ADMIN)
- DELETE /books/{id} (ADMIN)

---

## 🔑 Security
- JWT token-based authentication
- Role-based access control
- Password hashing using BCrypt

---

## ▶️ How to Run
1. Clone repository
2. Configure MySQL in application.properties
3. Run the application
4. Access Swagger:
   http://localhost:8081/swagger-ui.html

---

## 👨‍💻 Author
Ketan Behere