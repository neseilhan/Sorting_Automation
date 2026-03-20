package dev.neseilhan.sortingautomation.listeners;

import dev.neseilhan.sortingautomation.utils.ScreenshotUtils;
import io.qameta.allure.Attachment;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        attachScreenshot("FAIL - " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        attachScreenshot("PASS - " + result.getMethod().getMethodName());
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] attachScreenshot(String screenshotName) {
        return ScreenshotUtils.takeScreenshotAsBytes();
    }
}