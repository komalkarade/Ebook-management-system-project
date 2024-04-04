# Ebook-management-system-Maven-project

Below is a basic template for a README file for a Java Maven project using some JAR files, Tomcat 8, Bootstrap for the frontend, and JSTL pages. You can customize and expand upon this template based on the specific details and features of your project.

Ebook-management-system
The eBook Management System is a Java-based application tailored for educational institutions. It simplifies student information management with features like user authentication, gradebook tools, and resource management.
Old Version: The initial iteration of the EBOOK Management System provided basic functionalities like user authentication and student data management.

New Version: The updated version introduced improvements such as a modern user interface, mobile accessibility, and integration with other systems like Learning Management Systems.

Recent Version: The most recent iteration likely includes advanced features such as AI-driven analytics, predictive capabilities, and enhanced security measures to provide a comprehensive solution for educational institutions.

Table of Contents
Introduction
Prerequisites
Installation
Usage
Dependencies
Frontend
Contributing
License
Introduction
The Student Management System aims to streamline various aspects of student administration, including enrollment, course management, grading, and attendance tracking. With an intuitive interface, the system facilitates better organization and accessibility of student-related information.

Prerequisites
Ensure your system meets the following prerequisites:

Java
Maven
Tomcat 8
Installation
Clone the repository:

git clone  https://github.com/komalkarade/Ebook-management-system-project

1.1 Build the project using Maven: cd Ebook-management-system-project mvn clean install

1.2 Deploy the generated WAR file to Tomcat.



Dependencies jsp-api-2.2.jar jstl-1.2.jar mysql-connector-java-8.0.13.jar servlet-api-2.5.jar Make sure to add these JAR files to your project's classpath.

Frontend The frontend is designed using Bootstrap, ensuring a responsive and visually appealing user experience.

Contributing If you'd like to contribute, please follow the Contributing Guidelines.

sql table:
Table: book_dtls
CREATE TABLE book_dtls (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    bookname VARCHAR(45),
    author VARCHAR(45),
    price VARCHAR(45),
    bookCategory VARCHAR(45),
    status VARCHAR(45),
    photo VARCHAR(45),
    email VARCHAR(45)
);

Table: cart
CREATE TABLE cart (
    cid INT AUTO_INCREMENT PRIMARY KEY,
    book_id INT,
    userid INT,
    bookName VARCHAR(45),
    author VARCHAR(45),
    price DOUBLE,
    total_price DOUBLE
);

Table: user
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45),
    email VARCHAR(45),
    phno VARCHAR(45),
    password VARCHAR(45),
    address VARCHAR(45),
    landmark VARCHAR(45),
    city VARCHAR(45),
    state VARCHAR(45),
    pincode VARCHAR(45)
);
Table:  book_order

CREATE TABLE book_order (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(45),
    user_name VARCHAR(45),
    email VARCHAR(45),
    address VARCHAR(500),
    phno VARCHAR(45),
    book_name VARCHAR(45),
    author VARCHAR(45),
    price DOUBLE,
    payment VARCHAR(45)
);


