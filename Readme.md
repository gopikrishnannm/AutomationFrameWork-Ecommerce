
# Test Automation Framework

This is a Java based automation framework uses varioud libraries and tools to facilitate data-driven testing, logging, reporting, and integration with cloud-based testing platform like lambdatest. 

## Author

- [@gopikrishnannm](https://github.com/gopikrishnannm)

- EmailAddress: gopikrishnannm01@gmail.com


## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/gopikrishnannm)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gopikrishnan-n-m/)



## 🚀 About Me

Hi, my name is Gopikrishnan N M. I have 3 years of experience in Quality Assurance, with a strong background in both manual and automation testing. I have hands-on experience with Selenium WebDriver for UI automation, API testing using Postman, and writing SQL queries for backend validation. 

I also have a basic understanding of web technologies including Spring Boot and JavaScript, which helps me better understand the application flow and improve test coverage.


## Prerequsites

Before running this framework, ensure the following software is installed on your system

- **Java 11** - [Link](https://www.java.com/en/download/manual.jsp)
- **Maven** - [Link](https://maven.apache.org/download.cgi)

## Features
- **Data-Driven Testing**: Using OpenCSV, Apache POI, and Gson for reading test data from CSV and Excel files and JSON.

- **Cross-Browser Testing**: Supports running tests on different browsers.

- **Headless Mode**: Faster execution by running tests in headless mode.

- **Cloud Testing**: Integrated with LambdaTest to run tests on the cloud.

- **Logging**: Uses Log4j for detailed logs.

- **Reporting**: Generates detailed reports using Extent Reports.

## Technologies Used

- Java 11

- TestNG

- Log4j

- Extent Reports

- Faker

- LambdaTest

- Apache POI

- OpenCSV

- Gson











## Installation

**Clone the Repository**:

```bash
git clone https://github.com/gopikrishnannm/AutomationFrameWork-Ecommerce.git

cd AutomationFrameWork-Ecommerce

```
    
**Running Tests on LambdaTest**:

```bash
 mvn clean test -Dbrowser=chrome -DisLambda=true -DisHeadless=false

```


**Running Tests on Chrome browser on Local Machine in Headless Mode**:

```bash
 mvn clean test -Dbrowser=chrome -DisLambda=false -DisHeadless=true

```  

 ## Reports & Logs

 - **Reports**: After execution, a detailed HTML report will be generated at ./report.html.

- The report includes information of test cases that were executed, passed, failed, or skipped, along with screenshots for any failed tests.

- **Logs**: Logs are generated during test execution and stored in the ./logs/ directory. 


## GitHub Actions

This automation framework is integrated with github actions and the reports will be archived in gh-pages branch.You can view the html report at : https://gopikrishnannm.github.io/AutomationFrameWork-Ecommerce/report.html

