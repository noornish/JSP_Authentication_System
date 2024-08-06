# User Authentication System

The User Authentication System is a simple Java-based web application for handling user authentication, featuring both login and signup functionalities. This project demonstrates the use of servlets, JDBC, and JSP for managing user sessions and interactions with a MySQL database.

## Features

- User Login
- User Signup
- Input Validation
- Error Handling

## Prerequisites

- Java Development Kit (JDK)
- Apache Tomcat
- MySQL Database

## Database Setup
```
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);
```
## Directory Structure

```
user-authentication-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── yourpackage/
│   │   │           ├── LoginServlet.java
│   │   │           └── SignupServlet.java
│   │   ├── resources/
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       ├── login.jsp
│   │       └── signup.jsp
└── pom.xml
```

## Output

https://github.com/user-attachments/assets/1ba5bab1-7fa2-4985-b98d-76151762fdcd

## Usage

### Login

- Navigate to the login page.
- Enter your username and password.
- Click the "Login" button.
- If successful, a welcome message will appear.

### SignUp

- Navigate to the signup page.
- Enter your username, email, and password.
- Click the "Signup" button.
- If successful, a welcome message will appear.


