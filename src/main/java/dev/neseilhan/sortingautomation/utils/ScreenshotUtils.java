package dev.neseilhan.sortingautomation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    public static void takeScreenshotWithHighlight(WebDriver driver, WebElement element, String name) {
        try {
            highlight(driver, element);
            Thread.sleep(200); // delay for the highlight

            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            System.out.println("Highlighted screenshot failed: " + e.getMessage());
        }
    }

    private static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='rgba(255,0,0,0.1)';",
                element
        );
    }
}