# 📦 Spring Boot Categories & Products REST API

This is a Spring Boot project that manages **Categories** and their associated **Products** 
with a **One-to-Many** relationship. It uses **DTOs**, **ModelMapper**,
and provides a REST API to perform CRUD operations.

## 🧱 Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 / MySQL (single database)
- ModelMapper
- Maven

---

## 📁 Project Structure

src
└── main
├── java
│ └── com.example.demo
│ ├── controller
│ ├── dto
│ ├── entity
│ ├── repository
│ ├── service
│ └── impl
└── resources
└── application.properties

## 🔗 Database Relationship

- **Category 1 ⟶ N Product**
  - One category can have many products
  - Each product belongs to one category
## 📦 API Endpoints

### ✅ Category Endpoints

| Method | Endpoint                  | Description                  |
|--------|---------------------------|------------------------------|
| POST   | `/category/`              | Create a new category        |
| GET    | `/category/`              | Get all categories           |
| GET    | `/category/{name}`        | Get category by name         |

### 📦 Product Endpoints

| Method | Endpoint                         | Description                     |
|--------|----------------------------------|---------------------------------|
| POST   | `/product/`                      | Create a new product            |
| GET    | `/product/`                      | Get all products                |
| GET    | `/product/{id}`                  | Get product by ID               |
| GET    | `/product/category/{categoryId}` | Get all products by category ID |
| DELETE | `/product/{id}`                  | Delete product by ID            |

---

### 🧪 Sample Request (POST `/product/`)

```json
{
  "name": "Laptop",
  "price": 45000,
  "categoryId": 1
}


🚀 Run the Application
mvn spring-boot:run
Visit Swagger: http://localhost:8080/swagger-ui/

