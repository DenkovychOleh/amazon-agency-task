# Agency Amazon Task

### Table of Contents
1. [Introduction](#introduction)
2. [Requirements](#requirements)
3. [Installation](#installation)
4. [Swagger Documentation](#swagger)

## Introduction
AgencyAmazon Task is a web application designed to provide functionalities for managing sales and traffic reports, as well as user authentication. It offers endpoints for retrieving sales and traffic data by ASIN (Amazon Standard Identification Number) and date, as well as endpoints for user registration and authentication.

## Requirements
- Java Development Kit (JDK) 21
- Maven
- MongoDB

## Installation
To install and run the application locally, follow these steps:

1. Clone this repository to your local machine.
2. Navigate to the project directory.
3. Run the Maven command to build the project.
4. Run the application using Maven.
5. The application will start running on `http://localhost:8080`

## Swagger
Swagger is integrated into this project to provide interactive API documentation. With Swagger, you can easily explore and test the available endpoints without leaving your browser.

To access the Swagger documentation, follow these steps:

1. Ensure the application is running locally.
2. Open a web browser and navigate to `http://localhost:8080/swagger/swagger-ui/index.html#/`.
3. You will see the Swagger UI interface, which displays a list of available endpoints along with detailed information about each endpoint, including request and response formats.
4. Explore the available endpoints by expanding the sections and clicking on individual endpoints to view their details.
5. You can also test the endpoints directly from the Swagger UI interface by providing input parameters and executing requests.
