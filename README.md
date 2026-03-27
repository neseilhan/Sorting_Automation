## Sorting Automation Project

This project is a UI test automation framework built with Java, Selenium, TestNG, and Allure Reporting.
It validates sorting functionality on an e-commerce inventory page.

## Technologies Used

- Java 17
- Selenium WebDriver 4.29.0
- TestNG 7.11.0
- Maven
- Allure Reporting 2.29.1
- Page Object Model (POM)

## Project Architecture

The project follows Page Object Model (POM) design pattern for maintainability and scalability.

### Package Structure
```
src/
├── main/java/dev/neseilhan/sortingautomation/
│   ├── base/          # Base classes (DriverFactory)
│   ├── constants/     # Constants and enums
│   ├── pages/         # Page Object classes
│   └── utils/         # Utility classes
└── test/java/dev/neseilhan/sortingautomation/
    ├── listeners/     # TestNG listeners
    └── tests/         # Test classes
```

## Test Coverage

The following scenarios are automated:

🔤 **Sorting by Name**
- Name (A → Z)
- Name (Z → A)

💰 **Sorting by Price**
- Price (Low → High)
- Price (High → Low)

## Locator Strategy

**Primary locator strategy:** CSS Selectors
**Secondary locator strategy:** XPath (used for stable text-based elements)

**Examples:**
```java
By.cssSelector("[data-test='inventory-item-name']");
By.xpath("//span[@data-test='title' and text()='Products']");
```

## Cross Browser Support

Framework supports:

- Chrome ✅
- Firefox ✅

Browser configuration can be managed via `config.properties`.

## Screenshot & Failure Handling

- Automatic screenshot capture on test failure
- Screenshot capture on test success
- Highlighted element screenshot support (debug-friendly)
- Integrated with Allure Reports

## 📊 Allure Reporting

### Generate Report:
```bash
# Run tests and generate report in one command
mvn clean test && allure generate target/allure-results --clean -o target/allure-report && allure open target/allure-report

# Or step by step:
mvn clean test
allure generate target/allure-results --clean -o target/allure-report
allure open target/allure-report
```

### Report includes:
- Test steps (BDD style)
- Screenshots
- Execution details
- Failure analysis
- Test history

## Test Execution

### Run via IntelliJ IDEA
Right click on `testng.xml` → Run

### Run via Terminal
```bash
mvn clean test
```

### Run Specific Test Class
```bash
mvn test -Dtest=SortingTests
```

## Design Decisions

- **Page Object Model** for clean separation of concerns
- **Enum-based sorting options** for readability and maintainability
- **Stream API** used for data validation
- **Custom wait methods** for synchronization stability
- **Allure integrated** for advanced reporting and debugging

## Improvements Implemented

- Maintainable and stable locators
- Cross-browser execution support
- Parallel test execution
- BDD-style test steps (Given / When / Then)
- Screenshot capture with element highlighting
- Clean, modular, and scalable architecture

## Author

Nese İlhan
