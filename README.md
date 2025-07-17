# Employee Performance Management API

This Spring Boot application provides endpoints to manage employees, departments, projects, and performance reviews.

---

## Endpoints

### 1. Get Employee Details
- **GET** `/api/employees/{id}/details`
- Returns employee details with department, projects, and last 3 reviews.

### 2. Filter Employees
- **GET** `/api/employees/filter`
- Query Params:
    - `score` (Integer, optional)
    - `reviewDate` (Date in `YYYY-MM-DD` format, optional)
    - `departments` (List of strings, optional)
    - `projects` (List of strings, optional)

---

## Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven