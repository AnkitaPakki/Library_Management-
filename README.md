📚 Library Management System

A simple Spring Boot + MySQL CRUD application that manages Authors and Books with a One-to-Many relationship.

✨ Features

Add, view, and update Authors
Add, view, and update Books
Each Author can have multiple Books
REST APIs for all operations

🗃️ Technology Stack

Java 21
Spring Boot
Spring Data JPA
MySQL Database
Maven
IntelliJ IDEA

🏗️ ER Diagram
Author (1) → (Many) Book

Author
 ├─ id (PK)
 ├─ name
 ├─ email
 └─ bio

Book
 ├─ id (PK)
 ├─ title
 ├─ isbn
 ├─ published
 └─ author_id (FK → Author.id)

🔧 How to Run
1. Create MySQL Database
CREATE DATABASE library_management;

2. Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3. Build & Run
mvn clean install
mvn spring-boot:run

📌 API Endpoints
Authors
Method	Endpoint	Description
POST	/authors	Add new author
GET	/authors/{id}	Get author by ID
PUT	/authors/{id}	Update an author

Books
Method	Endpoint	Description
POST	/books	Add new book
GET	/books/{id}	Get book by ID
PUT	/books/{id}	Update a book

📂 Project Structure
src/
 └── main/java/com/example/library
       ├── controller
       ├── service
       ├── repository
       └── model
       



       
