# Student Registration Form

A **Java Swing-based application** that allows users to register students, validate input fields, and store data in a **MySQL database**.

---

## Features

- **Graphical User Interface (GUI)** built with Java Swing.
- Input validation for:
  - Name (non-empty)
  - Roll Number (unique)
  - Age (positive integer)
  - Email (valid format)
- Stores student records in **MySQL database** using JDBC.
- Prevents duplicate roll numbers with database constraints.
- Easy to extend with additional fields (e.g., courses, gender).

---

## Screenshots

*(You can add screenshots of your GUI here)*

---

## Database Setup

```sql
-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS studentDB;

-- Use the database
USE studentDB;

-- Create students table
CREATE DATABASE IF NOT EXISTS studentDB;

USE studentDB;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    roll_no VARCHAR(20) NOT NULL UNIQUE,
    age INT NOT NULL,
    email VARCHAR(50) NOT NULL
);

SELECT * FROM students
