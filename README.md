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

<img width="419" height="502" alt="s1" src="https://github.com/user-attachments/assets/4d881bd4-9cc3-43d5-9576-e3877f73af4d" />
<img width="429" height="510" alt="s2" src="https://github.com/user-attachments/assets/7691d1fd-ec23-4fd8-b4f6-935b3a84e210" />

---

## Database Setup

<img width="1470" height="956" alt="mySQL2" src="https://github.com/user-attachments/assets/18b3647d-c424-466b-9ee4-63fcf955bb4b" />

```sql
-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS studentDB;

-- Use the database
USE studentDB;

-- Create students table
CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    roll_no VARCHAR(20) NOT NULL UNIQUE,
    age INT NOT NULL,
    email VARCHAR(50) NOT NULL
);

-- Check data
SELECT * FROM students;



