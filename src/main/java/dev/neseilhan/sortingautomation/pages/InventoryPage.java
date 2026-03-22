package dev.neseilhan.sortingautomation.pages;

import dev.neseilhan.sortingautomation.base.BasePage;
import dev.neseilhan.sortingautomation.constants.SortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;
/**
 * Page Object representing the Inventory page.
 *
 * <p>Provides functionality for:
 * - retrieving product names and prices
 * - sorting products
 * - validating UI elements</p>
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class InventoryPage extends BasePage {

    private final By productsTitle = By.xpath("//span[@data-test='title' and text()='Products']");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By inventoryItems = By.cssSelector("[data-test='inventory-item-description']");
    private final By inventoryItemNames = By.cssSelector("[data-test='inventory-item-name']");
    private final By inventoryItemPrices = By.cssSelector("[data-test='inventory-item-price']");
    private final By shoppingCartLink = By.cssSelector("[data-test='shopping-cart-link']");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if inventory page is loaded.
     *
     * @return true if page is loaded
     */
    public boolean isPageLoaded() {
        return waitForVisibility(productsTitle).isDisplayed();
    }

    /**
     * Selects sorting option using visible text.
     *
     * @param visibleText sorting option text
     */
    public void selectSortOption(String visibleText) {
        WebElement dropdownElement = waitForVisibility(sortDropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Selects sorting option using enum.
     *
     * @param sortOption sorting option enum
     */
    public void selectSortOption(SortOption sortOption) {
        selectSortOption(sortOption.getVisibleText());
    }

    /**
     * Retrieves product names.
     *
     * @return list of product names
     */
    public List<String> getItemNames() {
        return waitForAllVisible(inventoryItemNames)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves product prices.
     *
     * @return list of product prices
     */
    public List<Double> getItemPrices() {
        return waitForAllVisible(inventoryItemPrices)
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    /**
     * Returns inventory item count.
     *
     * @return number of items
     */
    public int getInventoryItemCount() {
        return waitForAllVisible(inventoryItems).size();
    }


    /**
     * Gets selected sort option value.
     *
     * @return selected value (az, za, lohi, hilo)
     */
    public String getSelectedSortOptionValue() {
        WebElement dropdownElement = waitForVisibility(sortDropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getDomAttribute("value");
    }

    /**
     * Checks if shopping cart is displayed.
     *
     * @return true if visible
     */
    public boolean isShoppingCartDisplayed() {
        return waitForVisibility(shoppingCartLink).isDisplayed();
    }

    /**
     * Returns first product name element.
     *
     * @return WebElement of first item
     */
    public WebElement getFirstItemNameElement() {
        return waitForAllVisible(inventoryItemNames).get(0);
    }
}