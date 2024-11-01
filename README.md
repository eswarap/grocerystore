# Grocery Store Management System

## Description
The Grocery Store Management System is a web application built using Spring MVC that allows users to manage grocery items effectively. 
This application uses Hibernate for ORM, H2 as an in-memory database for testing and development, and follows the Transaction Script Pattern (TSP)
for handling business logic. Users can perform CRUD operations on grocery items and view them in a user-friendly interface.

## Features
- User-friendly interface to manage grocery items.
- CRUD operations (Create, Read, Update, Delete) for grocery products.
- Search functionality to quickly find grocery items.
- In-memory database using H2 for easy setup and testing.

## Technologies Used
- **Backend**: Spring MVC, Hibernate
- **Database**: H2 (in-memory)
- **Build Tool**: Maven
- **Design Pattern**: Transaction Script Pattern (TSP)

## Requirements
- Java JDK 11 or higher
- Maven 3.6 or higher

## Installation Instructions

1. **Clone the repository:**
   ```bash
   git clone https://github.com/eswarap/grocerystore.git
   cd grocerystore
2. **Build the project:**
   ```bash
   mvn clean install
3. **Run the application:**
   You can run the application using:
   ```bash
   mvn spring-boot:run
4.**Access the application:**
Open your browser and navigate to http://localhost:8080 to view the Grocery Store Management System.

### Database Configuration
   The application uses H2 as an in-memory database. You can configure it in application.properties located in src/main/resources:
      ```bash
      spring.h2.console.enabled=true
      spring.datasource.url=jdbc:h2:mem:testdb
      spring.datasource.driverClassName=org.h2.Driver
      spring.datasource.username=sa
      spring.datasource.password=password
      spring.jpa.hibernate.ddl-auto=create-drop

### License
This project is licensed under the MIT License - see the LICENSE file for details.

### Acknowledgments
Thanks to all contributors and libraries used in this project that made it possible.
