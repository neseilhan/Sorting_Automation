package dev.neseilhan.sortingautomation.tests;

import dev.neseilhan.sortingautomation.base.DriverFactory;
import dev.neseilhan.sortingautomation.pages.InventoryPage;
import dev.neseilhan.sortingautomation.pages.LoginPage;
import dev.neseilhan.sortingautomation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Base test class that handles WebDriver initialization and teardown.
 *
 * <p>This class is responsible for:
 * - Initializing WebDriver based on the provided browser parameter
 * - Navigating to the application URL
 * - Performing login before each test
 * - Quitting the driver after each test</p>
 *
 * <p>All test classes should extend this class.</p>
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    /**
     * Sets up the test environment before each test method.
     *
     * @param browser the browser type (chrome, edge)
     */
    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver);
        loginPage.open(ConfigReader.getProperty("base.url"));

        if (!loginPage.isLoginPageLoaded()) {
            throw new IllegalStateException("Login page did not load successfully.");
        }

        inventoryPage = loginPage.loginAs(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    /**
     * Closes the browser and cleans up driver after each test.
     */
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }

}