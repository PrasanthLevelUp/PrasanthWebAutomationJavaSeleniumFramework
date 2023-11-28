# Prasanth Web Selenium Test Automation Framework

This repository contains an automation testing framework built with Java, Selenium, TestNG, and other technologies to automate web applications.

## Prerequisites

Make sure you have the following installed on your machine:

- Java Development Kit (JDK)
- Maven

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/PrasanthLevelUp/PrasanthWebAutomationJavaSeleniumFramework.git


2. Navigate to the project directory:

   ```bash
    cd PrasanthWebAutomationJavaSeleniumFramework

3. Install dependencies using Maven:

    ```bash
   mvn clean install

4. Running Tests - Execute the following Maven command to run the tests:

   ```bash 
   mvn clean test

##Configuration:

Environment Profiles: The Maven profiles can be used to set up different environments (e.g., dev, test). Modify the src/test/resources/config.properties file accordingly.

##Reports

Test reports will be generated in the htmlReports directory. You can view the HTML reports by opening target/surefire-reports/emailable-report.html in a web browser.