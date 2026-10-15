# Spring Boot CRUD Operations API

A RESTful API project built using **Java and Spring Boot** to demonstrate CRUD (Create, Read, Update, Delete) operations while following a layered architecture. This project illustrates how requests flow through different layers of a Spring Boot application, ensuring clean code organization, separation of concerns, and maintainability.

## 🚀 Features

- **Create** – Add new records to the database.
- **Read** – Retrieve all records or fetch a specific record by ID.
- **Update** – Modify existing records.
- **Delete** – Remove records from the database.
- **Layered Architecture** – Separation of responsibilities across Controller, Service, Repository, and Entity/Model layers.
- **RESTful APIs** – Handle HTTP requests using standard HTTP methods.
- **Database Integration** – Persist and manage data using Spring Data JPA.
- **Exception Handling** – Handle invalid requests and record-related errors.

## 🛠️ Tech Stack

- **Language:** Java
- **Framework:** Spring Boot
- **Data Access:** Spring Data JPA, Hibernate
- **Database:** Configure your preferred database (e.g., MySQL or PostgreSQL)
- **Build Tool:** Maven
- **API Testing:** Postman
- **Version Control:** Git and GitHub

## 🏗️ Project Architecture

The application follows a layered architecture to separate business logic, request handling, and database operations.

```
Client (Postman / API Consumer)
             |
             v
       Controller Layer
             |
             v
        Service Layer
             |
             v
      Repository Layer
             |
             v
          Database
```

### Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Controller | Accepts HTTP requests and returns HTTP responses. |
| Service | Contains business logic and processes application requests. |
| Repository | Interacts with the database using Spring Data JPA. |
| Model / Entity | Represents the data structure mapped to database tables. |

## 🔄 Request Workflow

1. The client sends an HTTP request to a REST endpoint.
2. The Controller receives the request and passes the required data to the Service layer.
3. The Service layer executes the business logic.
4. The Repository layer performs the required database operation.
5. The database returns the result to the Repository.
6. The response travels back through the Service and Controller layers.
7. The client receives the appropriate HTTP response.

## 📡 CRUD Operations

The following table illustrates common REST endpoint patterns. Replace the example paths with the actual mappings implemented in your project.

| Operation | HTTP Method | Example Endpoint | Purpose |
|---|---|---|---|
| Create | POST | `/api/records` | Create a new record |
| Read All | GET | `/api/records` | Retrieve all records |
| Read by ID | GET | `/api/records/{id}` | Retrieve a record by ID |
| Update | PUT | `/api/records/{id}` | Update an existing record |
| Delete | DELETE | `/api/records/{id}` | Delete a record |

## ⚙️ Getting Started

### Prerequisites

Ensure you have installed:

- Java JDK
- Maven (or use the included Maven Wrapper)
- A supported relational database, if configured
- Postman or another REST API client

### Installation

**1. Clone the repository**

```bash
git clone https://github.com/sahil-kerketta/book-management-api.git
```

**2. Navigate to the project directory**

```bash
cd <your-repository>
```

**3. Configure the database**

Update `src/main/resources/application.properties` with your database connection details, if your project uses a database.

**4. Build the project**

On Windows:

```bash
mvnw.cmd clean package
```

Or, if Maven is installed:

```bash
mvn clean package
```

**5. Run the application**

```bash
mvnw.cmd spring-boot:run
```

Alternatively:

```bash
mvn spring-boot:run
```

The application will start on the configured port, typically `8080`, unless changed in your application configuration.

## 🧪 Testing the APIs

You can test the endpoints using Postman.

1. Start the Spring Boot application.
2. Select the appropriate HTTP method.
3. Enter the endpoint URL.
4. For POST and PUT requests, provide a JSON request body when required.
5. Send the request and inspect the response and HTTP status code.

## 🎯 Learning Objectives

This project demonstrates practical understanding of:

- Building RESTful APIs using Spring Boot.
- Implementing CRUD operations.
- Understanding layered architecture and separation of concerns.
- Add DTOs for request and response handling.
- Implement global exception handling.
- Using Spring Data JPA for database interactions.
- Mapping HTTP methods to application operations.
- Testing APIs using Postman.
- Managing a Java project using Maven and Git.

## 🔮 Future Enhancements


- Add input validation.
- Introduce pagination and sorting.
- Add unit and integration tests.
- Implement Spring Security and authentication.
- Containerize the application using Docker.

## 👨‍💻 Author

**Sahil Kerketta**

GitHub: [Your GitHub Profile](https://github.com/sahil-kerketta)

---

If you find this project useful for learning Spring Boot and REST API development, feel free to explore the code and build upon it.
