package dev.neseilhan.sortingautomation.tests;

import dev.neseilhan.sortingautomation.listeners.TestListener;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Listeners(TestListener.class)
@Epic("Inventory Management")
@Feature("Sorting")
public class SortingTests extends BaseTest {

    @Test
    @Story("Sort by Name Ascending")
    @Description("Verify that products are sorted by name in ascending alphabetical order (A to Z).")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSortByNameAscending() {
        Allure.step("Verify inventory page is loaded", () ->
                Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.")
        );

        Allure.step("Select sorting option: Name (A to Z)", () ->
                inventoryPage.selectSortOption("Name (A to Z)")
        );

        List<String> actualNames = new ArrayList<>();
        Allure.step("Get actual product names from UI", () ->
                actualNames.addAll(inventoryPage.getItemNames())
        );

        List<String> expectedNames = new ArrayList<>(actualNames);
        Allure.step("Sort expected product names in ascending order", () ->
                Collections.sort(expectedNames)
        );

        Allure.step("Verify actual product names match expected ascending order", () ->
                Assert.assertEquals(actualNames, expectedNames, "Items are not sorted by name from A to Z.")
        );
    }

    @Test
    @Story("Sort by Name Descending")
    @Description("Verify that products are sorted by name in descending alphabetical order (Z to A).")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSortByNameDescending() {
        Allure.step("Verify inventory page is loaded", () ->
                Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.")
        );

        Allure.step("Select sorting option: Name (Z to A)", () ->
                inventoryPage.selectSortOption("Name (Z to A)")
        );

        List<String> actualNames = new ArrayList<>();
        Allure.step("Get actual product names from UI", () ->
                actualNames.addAll(inventoryPage.getItemNames())
        );

        List<String> expectedNames = new ArrayList<>(actualNames);
        Allure.step("Sort expected product names in descending order", () ->
                expectedNames.sort(Collections.reverseOrder())
        );

        Allure.step("Verify actual product names match expected descending order", () ->
                Assert.assertEquals(actualNames, expectedNames, "Items are not sorted by name from Z to A.")
        );
    }

    @Test
    @Story("Sort by Price Ascending")
    @Description("Verify that products are sorted by price from low to high.")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSortByPriceLowToHigh() {
        Allure.step("Verify inventory page is loaded", () ->
                Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.")
        );

        Allure.step("Select sorting option: Price (low to high)", () ->
                inventoryPage.selectSortOption("Price (low to high)")
        );

        List<Double> actualPrices = new ArrayList<>();
        Allure.step("Get actual product prices from UI", () ->
                actualPrices.addAll(inventoryPage.getItemPrices())
        );

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Allure.step("Sort expected product prices in ascending order", () ->
                Collections.sort(expectedPrices)
        );

        Allure.step("Verify actual product prices match expected ascending order", () ->
                Assert.assertEquals(actualPrices, expectedPrices, "Items are not sorted by price from low to high.")
        );
    }

    @Test
    @Story("Sort by Price Descending")
    @Description("Verify that products are sorted by price from high to low.")
    @Severity(SeverityLevel.CRITICAL)
    public void shouldSortByPriceHighToLow() {
        Allure.step("Verify inventory page is loaded", () ->
                Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.")
        );

        Allure.step("Select sorting option: Price (high to low)", () ->
                inventoryPage.selectSortOption("Price (high to low)")
        );

        List<Double> actualPrices = new ArrayList<>();
        Allure.step("Get actual product prices from UI", () ->
                actualPrices.addAll(inventoryPage.getItemPrices())
        );

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Allure.step("Sort expected product prices in descending order", () ->
                expectedPrices.sort(Comparator.reverseOrder())
        );

        Allure.step("Verify actual product prices match expected descending order", () ->
                Assert.assertEquals(actualPrices, expectedPrices, "Items are not sorted by price from high to low.")
        );
    }
}