# Spring Boot Performance Comparison: Traditional vs. Virtual Threads

## Introduction

This Spring Boot application is designed to compare the performance between traditional threads and virtual threads, 
focusing on simple database operations. Developed using Java 21 and connected to a MySQL database, it aims to provide 
insights into the efficiency, speed, and resource utilization of each threading model under similar conditions.

## Prerequistes

Before you run this application, ensure you have the following installed:
- Java 21 or later
- MySQL ( Version 8.0 or later recommended)
- Gradle ( Version 8.0 or later recommended)

Additionally, make sure to configure your MySQL instance according to the application's `application.properties` file,
or adjust the file to match your database setup.

## Getting Started

To get the application up and running on your local machine for development and testing, follow these steps:

1. **Clone the repository**

```bash
git clone https://github.com/pkawale/performanceComparator.git
cd performanceComparator
```
2. **Configure the Application**

Edit the `src/main/resources/application.properties` file to set your database connection properties:

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/yourdatabase
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
```

3. **Run the Application**

You can run the application directly if you are using STS/ Intellij or any other IDE. 
Else, if you are using macOS / Linux, go to the root directory of the project and run:

```bash
./gradlew bootRun
```

If you are using Windows, you might need to use `gradlew.bat` instead:

```bash
gradlew.bat bootRun
```

## Acknowledgments

- Thanks to @danvega for the awesome run through on virtual threads.