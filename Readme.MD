# UI Test Framework created using Selenium + TestNG + Cucumber + Maven with Allure Reporting.

The tech stack used for this framework creation are:

1. JAVA as the programming language for writing test code
2. TestNG as the testing framework
3. Maven as the build tool
4. IntelliJ as the preferred IDE for writing java code.
5. Selenium as the automation framework

## Getting Started. Required softwares.

1. Install JDK 8 or above
2. Install IntelliJ (latest Community edition)
3. Install Maven
4. Install Git
5. Install npm for viewing allure report

## Cloning & Importing the Project
1. Clone the project using 'Get from version control' option in intellij
2. Import the project in IntelliJ and wait for all the dependencies to be downloaded

## Run Project as TestNG and using Maven commands
1. To Run as testNG, right click on the testNG.xml file and click on run. To specify which scenario to execute,
   specify them as tag in 'TestNGCucumberScenarioRunner' file.
2. Execute as maven using - *mvn test verify -D"cucumber.options=--tags @Regression"* command in terminal tab of intellij.

Kindly use the below link for fixing issues when running using maven commands - https://www.baeldung.com/java-lang-unsupportedclassversion

## Viewing the test report
1. Install npm
2. Install allure via terminal tab using *npm install -g allure-commandline —save-dev* command
3. To view the report, execute the command *allure serve target/allure-results* via terminal tab in intellij.


## Framework on High level.
This framework is developed using Selenium for Java along with testNG and using BDD approach(cucumber).

1. Shared Test Context
2. Implemented Configuration Reader
3. Tests are written in Gherkin format using feature files
4. Console logs are viewed using log4j.
5. Result are viewed in Allure reporting with Request and Responses.












