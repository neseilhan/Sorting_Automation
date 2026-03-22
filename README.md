## Sorting Automation Project

This project is a UI test automation framework built with Java, Selenium, TestNG, and Allure Reporting.
It validates sorting functionality on an e-commerce inventory page.

Technologies Used
Java 8+
Selenium WebDriver
TestNG
Maven
Allure Reporting
WebDriverManager (optional)
Page Object Model (POM)

## Project Architecture

The project follows Page Object Model (POM) design pattern for maintainability and scalability.

Test Coverage

The following scenarios are automated:

🔤 Sorting by Name
Name (A → Z)
Name (Z → A)

💰 Sorting by Price
Price (Low → High)
Price (High → Low)

Locator Strategy
Primary locator strategy: CSS Selectors
Secondary locator strategy: XPath (used for stable text-based elements)

Examples:

By.cssSelector("[data-test='inventory-item-name']");
By.xpath("//span[@data-test='title' and text()='Products']");

### Cross Browser Support

Framework supports:

Chrome ✅
Edge ✅

Browser configuration can be managed via config.properties.

Screenshot & Failure Handling
Automatic screenshot capture on test failure
Highlighted element screenshot support (debug-friendly)
Integrated with Allure Reports

### 📊 Allure Reporting
Generate Report:
allure serve allure-results

Report includes:

Test steps (BDD style)
Screenshots
Execution details
Failure analysis
Test Execution:
Run via IntelliJ

Right click → Run TestNG

Run via Terminal

mvn clean test

### Design Decisions

Page Object Model for clean separation of concerns
Enum-based sorting options for readability and maintainability
Stream API used for data validation
Custom wait methods for synchronization stability
Allure integrated for advanced reporting and debugging
### Improvements Implemented
Maintainable and stable locators
Cross-browser execution support
BDD-style test steps (Given / When / Then)
Screenshot capture with element highlighting
Clean, modular, and scalable architecture

### Future Enhancements

CI/CD integration (GitHub Actions)

#### Author

Nese İlhan
