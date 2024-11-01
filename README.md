# FileHub

Welcome to the application! This Java-based application provides a user interface for uploading files. It is designed to demonstrate basic Java Swing components, including labels, text fields, buttons, and progress bars.

## Features

- **User Authentication**: Sign up and log in with email verification using OTP.
- **Intuitive GUI**: User-friendly interface built with Java Swing.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- MySQL database

## Getting Started

### Setting Up the Database

1. Install MySQL and create a database named `UserDB`.
2. Create the necessary tables:

    ```sql
    CREATE DATABASE UserDB;

    USE UserDB;

    CREATE TABLE users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        name VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL UNIQUE,
        password VARCHAR(100) NOT NULL
    );
    ```

### Configuration

1. Clone the repository:
    ```sh
    git clone https://github.com/yash037/Filehub
    cd FileHub
    ```

2. Configure database connection:
    - Open `db/MyConnection.java`.
    - Modify the following line with your MySQL username and password:

   ```java
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDB?useSSl=false", "root", "yourpassword");
    ```

3. Configure email service:
    (For development purpose only)
    - Open `service/SendOTPService.java`.
    - Replace the email and password with your own Gmail credentials:

    ```java
        String from = "your-email@gmail.com";
        return new PasswordAuthentication(from, "your-email-password");
    ```

## Running the Application

### To run via CLI

1. Make sure to install Maven.
2. Go to the root directory where POM file is present.
3. Execute the following to compile the project.
    ```sh
    mvn package
    ```
4. Go to the "target" directory and execute the jar file.
    ```sh
    java -jar your/jar_file/path.jar
    ```

 **NOTE:** IntelliJ and other IDEs having built-in Maven support can run the application by running the MainApp.java file (Click the "Run" button).


### Using the Application

- **Sign Up**:
  - Enter your name and email.
  - An OTP will be sent to your email. Enter the OTP to complete the sign-up process.

- **Login**:
  - Enter your registered email and password.


## Project Structure

- **Controller/**: Contains the main entry point of the application.
- **dao/**: Data Access Objects for interacting with the database.
- **db/**: Database connection class.
- **model/**: Model classes representing User and File entities.
- **service/**: Services for generating and sending OTP, and managing user data.
- **views/**: GUI classes for the welcome screen, login/signup, and main menu.

## Contributing

- [Yash Sharma](https://github.com/yash037)
- [Lokesh Laxman Wagh](https://github.com/lokesh-wagh)
- [Utkarsh Singh](https://github.com/Utkarsh3212)


## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

-  ``Java Swing for GUI components.``
-  ``JavaMail API for sending OTP emails. ``
-  ``MySQL for the database.``
