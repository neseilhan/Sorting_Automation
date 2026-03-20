package dev.neseilhan.sortingautomation.pages;

import dev.neseilhan.sortingautomation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private final By pageTitle = By.xpath("//span[@class='title' and text()='Products']");
    private final By sortDropdown = By.cssSelector(".product_sort_container");
    private final By itemNames = By.cssSelector(".inventory_item_name");
    private final By itemPrices = By.cssSelector(".inventory_item_price");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return waitForVisibility(pageTitle).isDisplayed();
    }

    public void selectSortOption(String visibleText) {
        WebElement dropdownElement = waitForVisibility(sortDropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    public List<String> getItemNames() {
        return waitForAllVisible(itemNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getItemPrices() {
        return waitForAllVisible(itemPrices)
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}