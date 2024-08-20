#VehicleHistoryReportGenerator
Spring web application that allows users to enter a Vehicle Identification Number (VIN) and receive a detailed vehicle history report. This report includes information like previous owners, accident history, maintenance records, and mileage.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies](#technologies)
- [Setup Instructions](#setup-instructions)
- [License](#license)
- 
## Overview
This project is a vehicle history report system built using Java Spring Boot. It includes CRUD operations for vehicles, owners, accidents, maintenance records, and mileage. It utilizes a MySQL database for data storage and Thymeleaf for rendering HTML templates.

## Features
- VIN input and validation.
- Fetching vehicle history from a mock database.
- Generating and displaying a comprehensive vehicle history report
- Yearly Summaries: Track your overall visits for the year.
- Exporting the report as a PDF. (Still need to implement)

## Technologies
- **Java 22.0.1**
- **Java Spring Boot 3.3.2**
- **MySQL**
- **Thymeleaf**
- **Spring Data JPA**
- **JUnit 5**
- **Maven**

## Getting Started
### Prerequisites
- Java 11 or higher
- Maven 3.x
- MySQL Server

## License
This project is licensed under the MIT License - see the LICENSE file for details.
