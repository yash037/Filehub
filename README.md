# Filehub

Welcome to the application! This Java-based application provides a user interface for uploading files. It is designed to demonstrate basic Java Swing components, including labels, text fields, buttons, and progress bars.

## Features

- User-friendly interface for file uploads
- File chooser to select files
- Progress bar to indicate upload status
- Upload and Cancel functionality
-
- 

## Prerequisites
- Java JDK 21
- MySQL Server
- MySQL Connector/J (Java Database Connectivity Driver)

## Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/FileHub.git
cd FileHub
```

### 2. Configure Database
- Open MySQL and create a database (e.g., `filehub_db`).
- Run the following SQL script to create the `Users` table:

```sql
CREATE TABLE Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(100)
);
```

### 3. Configure Properties
In `config/config.properties`, update your database credentials:

```properties
db.url=jdbc:mysql://localhost:3306/filehub_db
db.username=your_db_username
db.password=your_db_password
```

### 4. Add MySQL Connector JAR
Download [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) if it’s not included, and add it to your project's classpath:
- **Command Line**: Include the JAR file in your classpath when running the application.
  ```bash
  java -cp .:path/to/mysql-connector-java-8.0.31.jar:filehub_db.jar filehub.FileHub
  ```
- **IDE**: If you’re using an IDE, add the MySQL Connector JAR file to the project’s libraries or dependencies. (like Netbeans)

### 5. Run the Project
Compile and run the project with your preferred method:
- **Command Line**:
  ```bash
  javac -cp path/to/mysql-connector-java-8.0.31.jar filehub/*.java
  java -cp .:path/to/mysql-connector-java-8.0.31.jar filehub.FileHub
  ```
- **IDE**: Open the project in your IDE, locate the main class (`FileHub.java`), and run it.

## Note
This project assumes a local MySQL setup. Update `db.url` if you are using a different host.