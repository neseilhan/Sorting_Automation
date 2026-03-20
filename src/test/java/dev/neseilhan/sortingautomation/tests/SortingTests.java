package dev.neseilhan.sortingautomation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingTests extends BaseTest {

    @Test
    public void shouldSortByNameAscending() {
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");

        inventoryPage.selectSortOption("Name (A to Z)");

        List<String> actualNames = inventoryPage.getItemNames();
        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);

        Assert.assertEquals(actualNames, expectedNames, "Items are not sorted by name from A to Z.");
    }

    @Test
    public void shouldSortByNameDescending() {
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");

        inventoryPage.selectSortOption("Name (Z to A)");

        List<String> actualNames = inventoryPage.getItemNames();
        List<String> expectedNames = new ArrayList<>(actualNames);
        expectedNames.sort(Collections.reverseOrder());

        Assert.assertEquals(actualNames, expectedNames, "Items are not sorted by name from Z to A.");
    }

    @Test
    public void shouldSortByPriceLowToHigh() {
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");

        inventoryPage.selectSortOption("Price (low to high)");

        List<Double> actualPrices = inventoryPage.getItemPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices, "Items are not sorted by price from low to high.");
    }

    @Test
    public void shouldSortByPriceHighToLow() {
        Assert.assertTrue(inventoryPage.isPageLoaded(), "Inventory page did not load successfully.");

        inventoryPage.selectSortOption("Price (high to low)");

        List<Double> actualPrices = inventoryPage.getItemPrices();
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Comparator.reverseOrder());

        Assert.assertEquals(actualPrices, expectedPrices, "Items are not sorted by price from high to low.");
    }
}