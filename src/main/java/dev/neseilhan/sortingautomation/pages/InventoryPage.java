package dev.neseilhan.sortingautomation.pages;

import dev.neseilhan.sortingautomation.base.BasePage;
import dev.neseilhan.sortingautomation.constants.SortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    private final By productsTitle = By.cssSelector("[data-test='title']");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By inventoryItems = By.cssSelector("[data-test='inventory-item-description']");
    private final By inventoryItemNames = By.cssSelector("[data-test='inventory-item-name']");
    private final By inventoryItemPrices = By.cssSelector("[data-test='inventory-item-price']");
    private final By shoppingCartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageLoaded() {
        return waitForVisibility(productsTitle).isDisplayed();
    }

    public void selectSortOption(String visibleText) {
        WebElement dropdownElement = waitForVisibility(sortDropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    public void selectSortOption(SortOption sortOption) {
        selectSortOption(sortOption.getVisibleText());
    }

    public List<String> getItemNames() {
        return waitForAllVisible(inventoryItemNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public List<Double> getItemPrices() {
        return waitForAllVisible(inventoryItemPrices)
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public int getInventoryItemCount() {
        return waitForAllVisible(inventoryItems).size();
    }

    public String getSelectedSortOptionValue() {
        WebElement dropdownElement = waitForVisibility(sortDropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getDomAttribute("value");
    }

    public boolean isShoppingCartDisplayed() {
        return waitForVisibility(shoppingCartLink).isDisplayed();
    }
    public WebElement getFirstItemNameElement() {
        return waitForAllVisible(inventoryItemNames).get(0);
    }
}