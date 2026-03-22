package dev.neseilhan.sortingautomation.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.*;

import java.io.ByteArrayInputStream;
/**
 * Utility class for capturing screenshots.
 *
 * <p>Supports:
 * - Full page screenshots
 * - Highlighted element screenshots</p>
 *
 * Screenshots are attached to Allure reports.
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    /**
     * Captures a full-page screenshot.
     *
     * @param driver WebDriver instance
     * @param name   screenshot name
     */
    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
        }
    }

    /**
     * Captures a screenshot with highlighted element.
     *
     * @param driver  WebDriver instance
     * @param element element to highlight
     * @param name    screenshot name
     */
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

    /**
     * Highlights a WebElement using JavaScript.
     *
     * @param driver  WebDriver instance
     * @param element element to highlight
     */
    private static void highlight(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='rgba(255,0,0,0.1)';",
                element
        );
    }
}