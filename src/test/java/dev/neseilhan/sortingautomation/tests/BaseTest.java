package dev.neseilhan.sortingautomation.tests;

import dev.neseilhan.sortingautomation.base.DriverFactory;
import dev.neseilhan.sortingautomation.pages.InventoryPage;
import dev.neseilhan.sortingautomation.pages.LoginPage;
import dev.neseilhan.sortingautomation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();

        loginPage = new LoginPage(driver);
        loginPage.open(ConfigReader.getProperty("base.url"));
        inventoryPage = loginPage.loginAs(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}