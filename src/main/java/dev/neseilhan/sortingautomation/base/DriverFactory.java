package dev.neseilhan.sortingautomation.base;

import dev.neseilhan.sortingautomation.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
/**
 * Factory class for managing WebDriver instances.
 *
 * <p>Supports:
 * - Chrome
 * - Edge
 *
 * Uses ThreadLocal for parallel execution support.
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
    }


    /**
     * Initializes WebDriver based on browser type.
     *
     * @param browser browser name
     */
    public static void initDriver(String browser) {
        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = createChromeDriver();
                break;
            case "edge":
                driver = createEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
    }

    private static WebDriver createChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        String chromeDriverPath = ConfigReader.getProperty("chrome.driver.path", "");

        try {
            if (!chromeDriverPath.isBlank()) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            } else {
                WebDriverManager.chromedriver().setup();
            }
        } catch (Exception e) {
            System.out.println("WebDriverManager could not set up ChromeDriver. Falling back to Selenium Manager.");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        EdgeOptions options = new EdgeOptions();

        String edgeDriverPath = ConfigReader.getProperty("edge.driver.path", "");

        try {
            if (!edgeDriverPath.isBlank()) {
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                System.out.println("Using local EdgeDriver from: " + edgeDriverPath);
            } else {
                WebDriverManager.edgedriver().setup();
            }
        } catch (Exception e) {
            System.out.println("WebDriverManager could not set up EdgeDriver. Falling back to Selenium Manager.");
        }

        return new EdgeDriver(options);
    }

    /**
     * Returns current thread WebDriver.
     *
     * @return WebDriver instance
     */
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    /**
     * Quits driver and removes from ThreadLocal.
     */
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}