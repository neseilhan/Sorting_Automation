package dev.neseilhan.sortingautomation.listeners;

import dev.neseilhan.sortingautomation.base.DriverFactory;
import dev.neseilhan.sortingautomation.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG listener implementation for capturing screenshots on test execution events.
 *
 * <p>This listener captures:
 * - Screenshot on test failure
 * - Screenshot on test success</p>
 *
 * Screenshots are attached to Allure reports.
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class TestListener implements ITestListener {

    /**
     * Triggered when a test fails.
     *
     * @param result test result information
     */
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        try {
            ScreenshotUtils.takeScreenshot(driver, "FAIL - " + result.getMethod().getMethodName());
        } catch (Exception e) {
            System.out.println("Listener failure screenshot error: " + e.getMessage());
        }
    }

    /**
     * Triggered when a test passes.
     *
     * @param result test result information
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        try {
            ScreenshotUtils.takeScreenshot(driver, "PASS - " + result.getMethod().getMethodName());
        } catch (Exception e) {
            System.out.println("Listener success screenshot error: " + e.getMessage());
        }

    }

}