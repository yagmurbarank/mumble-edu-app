<h1 align="center"><b>MumbleEdu 🐧</b></h1>
<h3 align="center"><b>Online Course Platform </b></h3>
<!-- PROJECT LOGO -->
<br />
<div align="center">

  <a href="https://github.com/yagmurbarank/OnlineCoursePlatform-Java-Spring">
    <img src="img/logo.png" alt="Logo" width="250" height="250">
  </a>
  </div>
<!-- ABOUT THE PROJECT -->

## About the Project ✨

###  What is MumbleEdu❔
<br/>
MumbleEdu is an online course platform designed to help students and lifelong learners discover and learn new skills. Built with Java and Spring Boot, it leverages MySQL for database management, Docker for containerization, Postman for API testing, and Swagger for API documentation.
<br/>

### ⚙ Features
- User Management: Supports different user roles including Tutor and Student, both extending from a base User class.
- Course Management: Tutors can create and manage courses, while students can enroll in courses.
- Enrollment: Students can enroll in courses, and their enrollment status is tracked.
- API Documentation: Comprehensive API documentation using Swagger.
- Containerization: Docker support for easy deployment and scalability.




### 💻 Built With
- Java: Core programming language.
- Spring Boot: Framework for building the application.
- MySQL: Database management system.
- Docker: Containerization platform.
- Postman: Tool for API testing.
- Swagger: API documentation tool.

### ⚔ Getting Started

#### Prerequisites
- Java 11 or higher
- Docker
- MySQL
- Postman (optional, for API testing)

### 📥 Installation
Clone the repository to your Desktop:
1. Open the cmd


2. cd Desktop:
   ```sh
    cd Desktop
   ```
3. Clone the repo:
   ```sh
   git clone https://github.com/yagmurbarank/OnlineCoursePlatform-Java-Spring
   ```
4. cd Project File:
   ```sh
   cd OnlineCoursePlatform-Java-Spring
   ```
5. Set up the database:
   ```sh
   Create a MySQL database named OnlineCoursePlatform-Java-Spring
   ```
6. Update the application.properties file with your MySQL credentials.


7. Run with Docker:
    ```sh
    docker-compose up --build
    ```
8. Build and run the application:
    ```sh
     ./mvnw spring-boot:run
   ```

### 📜 API Documentation
Access the API documentation at http://localhost:8081/swagger-ui.html once the application is running.

### 🔎 Usage
- Tutors: Can create, update, and delete courses.
- Students: Can browse available courses and enroll in them.
- Enrollment: Students’ enrollments are tracked and managed.









 
