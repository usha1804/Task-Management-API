# Task-Management-API
# Task Management API

A simple **RESTful Task Management API** built with **Java Spring Boot**, using in-memory storage. This project allows users to create, read, update, delete, and mark tasks as complete.

---

## Table of Contents

- [Overview](#overview)  
- [Features](#features)  
- [Technology Stack](#technology-stack)  
- [Getting Started](#getting-started)  
- [API Endpoints](#api-endpoints)  
- [Sample Requests & Responses](#sample-requests--responses)  
- [Design Decisions](#design-decisions)  
- [Unit Tests](#unit-tests)  

---

## Overview

This project implements a task management system with the following capabilities:

- Create tasks  
- View all tasks  
- View a task by ID  
- Update task details  
- Delete tasks  
- Mark tasks as complete  

The project uses **in-memory storage** (`Map<Long, Task>`), eliminating the need for a database.

---

## Features

- Fully functional CRUD operations  
- Mark tasks as complete  
- Input validation and error handling  
- HTTP status codes used appropriately (`200`, `201`, `204`, `404`)  
- Unit tests for critical functionality  

---

## Technology Stack

- **Java 21**  
- **Spring Boot 3.5.7**  
- **Lombok**  
- **Maven**  
- **JUnit 5**  

---

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone <your-github-repo-link>
   cd Task-Management-API

2. Build the project:
   mvn clean install
   
4. Run the application:
   mvn spring-boot:run
   
6. Access API
   Base URL: http://localhost:8085
