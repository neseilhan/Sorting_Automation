package dev.neseilhan.sortingautomation.listeners;

import dev.neseilhan.sortingautomation.base.DriverFactory;
import dev.neseilhan.sortingautomation.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();

        try {
            ScreenshotUtils.takeScreenshot(driver, "FAIL - " + result.getMethod().getMethodName());
        } catch (Exception e) {
            System.out.println("Listener failure screenshot error: " + e.getMessage());
        }
    }

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