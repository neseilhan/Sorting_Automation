package dev.neseilhan.sortingautomation.utils;

import dev.neseilhan.sortingautomation.base.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static byte[] takeScreenshotAsBytes() {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}