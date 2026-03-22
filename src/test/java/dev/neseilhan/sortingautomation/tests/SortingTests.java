package dev.neseilhan.sortingautomation.tests;

import dev.neseilhan.sortingautomation.constants.SortOption;
import dev.neseilhan.sortingautomation.listeners.TestListener;
import dev.neseilhan.sortingautomation.utils.SortUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(TestListener.class)
@Epic("Inventory Management")
@Feature("Sorting")
public class SortingTests extends BaseTest {

    @Test
    @Story("Sort by Name Ascending")
    @Description("Verify that products are sorted by name in ascending alphabetical order (A to Z).")
    @Severity(SeverityLevel.CRITICAL)
    public void userShouldSeeProductsSortedByNameAscending() {
        Allure.step("Given the user is on the inventory page", () -> {
            Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");
            Assert.assertTrue(inventoryPage.isShoppingCartDisplayed(), "Shopping cart icon is not displayed.");
            Assert.assertTrue(inventoryPage.getInventoryItemCount() > 0, "Inventory item list should not be empty.");
        });

        Allure.step("When the user selects Name (A to Z) sorting option", () ->
                inventoryPage.selectSortOption(SortOption.NAME_ASC)
        );

        Allure.step("Then the selected sorting option value should be 'az'", () ->
                Assert.assertEquals(
                        inventoryPage.getSelectedSortOptionValue(),
                        SortOption.NAME_ASC.getValue(),
                        "Selected sort option value is incorrect for Name (A to Z)."
                )
        );

        List<String> actualNames = inventoryPage.getItemNames();

        Allure.step("And the product names list should not be empty", () ->
                Assert.assertFalse(actualNames.isEmpty(), "Product name list should not be empty.")
        );

        List<String> expectedNames = SortUtils.sortStringsAscending(actualNames);

        Allure.step("And the actual product names should match the expected ascending order", () ->
                Assert.assertEquals(
                        actualNames,
                        expectedNames,
                        "Items are not sorted by name from A to Z."
                )
        );
    }

    @Test
    @Story("Sort by Name Descending")
    @Description("Verify that products are sorted by name in descending alphabetical order (Z to A).")
    @Severity(SeverityLevel.CRITICAL)
    public void userShouldSeeProductsSortedByNameDescending() {
        Allure.step("Given the user is on the inventory page", () -> {
            Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");
            Assert.assertTrue(inventoryPage.isShoppingCartDisplayed(), "Shopping cart icon is not displayed.");
            Assert.assertTrue(inventoryPage.getInventoryItemCount() > 0, "Inventory item list should not be empty.");
        });

        Allure.step("When the user selects Name (Z to A) sorting option", () ->
                inventoryPage.selectSortOption(SortOption.NAME_DESC)
        );

        Allure.step("Then the selected sorting option value should be 'za'", () ->
                Assert.assertEquals(
                        inventoryPage.getSelectedSortOptionValue(),
                        SortOption.NAME_DESC.getValue(),
                        "Selected sort option value is incorrect for Name (Z to A)."
                )
        );

        List<String> actualNames = inventoryPage.getItemNames();

        Allure.step("And the product names list should not be empty", () ->
                Assert.assertFalse(actualNames.isEmpty(), "Product name list should not be empty.")
        );

        List<String> expectedNames = SortUtils.sortStringsDescending(actualNames);

        Allure.step("And the actual product names should match the expected descending order", () ->
                Assert.assertEquals(
                        actualNames,
                        expectedNames,
                        "Items are not sorted by name from Z to A."
                )
        );
    }

    @Test
    @Story("Sort by Price Ascending")
    @Description("Verify that products are sorted by price from low to high.")
    @Severity(SeverityLevel.CRITICAL)
    public void userShouldSeeProductsSortedByPriceLowToHigh() {
        Allure.step("Given the user is on the inventory page", () -> {
            Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");
            Assert.assertTrue(inventoryPage.isShoppingCartDisplayed(), "Shopping cart icon is not displayed.");
            Assert.assertTrue(inventoryPage.getInventoryItemCount() > 0, "Inventory item list should not be empty.");
        });

        Allure.step("When the user selects Price (low to high) sorting option", () ->
                inventoryPage.selectSortOption(SortOption.PRICE_LOW_TO_HIGH)
        );

        Allure.step("Then the selected sorting option value should be 'lohi'", () ->
                Assert.assertEquals(
                        inventoryPage.getSelectedSortOptionValue(),
                        SortOption.PRICE_LOW_TO_HIGH.getValue(),
                        "Selected sort option value is incorrect for Price (low to high)."
                )
        );

        List<Double> actualPrices = inventoryPage.getItemPrices();

        Allure.step("And the product prices list should not be empty", () ->
                Assert.assertFalse(actualPrices.isEmpty(), "Product price list should not be empty.")
        );

        List<Double> expectedPrices = SortUtils.sortDoublesAscending(actualPrices);

        Allure.step("And the actual product prices should match the expected ascending order", () ->
                Assert.assertEquals(
                        actualPrices,
                        expectedPrices,
                        "Items are not sorted by price from low to high."
                )
        );
    }

    @Test
    @Story("Sort by Price Descending")
    @Description("Verify that products are sorted by price from high to low.")
    @Severity(SeverityLevel.CRITICAL)
    public void userShouldSeeProductsSortedByPriceHighToLow() {
        Allure.step("Given the user is on the inventory page", () -> {
            Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");
            Assert.assertTrue(inventoryPage.isShoppingCartDisplayed(), "Shopping cart icon is not displayed.");
            Assert.assertTrue(inventoryPage.getInventoryItemCount() > 0, "Inventory item list should not be empty.");
        });

        Allure.step("When the user selects Price (high to low) sorting option", () ->
                inventoryPage.selectSortOption(SortOption.PRICE_HIGH_TO_LOW)
        );

        Allure.step("Then the selected sorting option value should be 'hilo'", () ->
                Assert.assertEquals(
                        inventoryPage.getSelectedSortOptionValue(),
                        SortOption.PRICE_HIGH_TO_LOW.getValue(),
                        "Selected sort option value is incorrect for Price (high to low)."
                )
        );

        List<Double> actualPrices = inventoryPage.getItemPrices();

        Allure.step("And the product prices list should not be empty", () ->
                Assert.assertFalse(actualPrices.isEmpty(), "Product price list should not be empty.")
        );

        List<Double> expectedPrices = SortUtils.sortDoublesDescending(actualPrices);

        Allure.step("And the actual product prices should match the expected descending order", () ->
                Assert.assertEquals(
                        actualPrices,
                        expectedPrices,
                        "Items are not sorted by price from high to low."
                )
        );
    }
}