## Teacher Student Connect

#### Introduction
In education domain there is always a need for a teacher to access various information of his/her cohort of students. It includes demographic details, educational qualifications, academic courses, marks and grades, review of results among a few. A teacher needs a platform to view and access all these details and get a holistic view of the cohort. 
As part of the web platform, a web application has been developed with a subset of functionalities. Here a teacher after login can view the details of the students in a compact manner with search functionality. He/she can also add new students by providing the appropriate details.

#### Software Checklist
*   Java 8
*   Spring Boot 4.0
*   Spring Thymeleaf
*   Spring JPA
*   HTML, Bootstrap CSS 3.4, Bootstrap JS
*   MySQL 8.0.23
*    Maven 3.6


#### Pre- Requisite
1.	MySQL database setup
    *   Create a database named ‘teacherstudentconnect’

Instructions for executing the Code
1.	Extract the codebase zip file into a suitable folder
2.	In Eclipse, import Maven Project and select the extracted folder
3.	After the project is successfully imported, check the build path and set it to JDK 1.8
4.	Open application.properties in src/main/resources folder and change the datasource URL and credentials
5.	Execute the teacherconnect.sql SQL script to insert records in the tables    
6.	Run PMD through maven command
    *   mvn pmd:pmd
7.	Build the application using the maven command to create the jar
    *   mvn clean install
8.	Execute the application as
    *   java -jar teacherstudentconnect.jar

