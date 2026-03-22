package dev.neseilhan.sortingautomation.constants;
/**
 * Enum representing sorting options available in the application.
 *
 * Each option contains:
 * - visible text (UI)
 * - value (HTML attribute)
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public enum SortOption {

    /**
     * Sort by name ascending (A → Z)
     */
    NAME_ASC("Name (A to Z)", "az"),

    /**
     * Sort by name descending (Z → A)
     */
    NAME_DESC("Name (Z to A)", "za"),

    /**
     * Sort by price low to high
     */
    PRICE_LOW_TO_HIGH("Price (low to high)", "lohi"),

    /**
     * Sort by price high to low
     */
    PRICE_HIGH_TO_LOW("Price (high to low)", "hilo");

    private final String visibleText;
    private final String value;

    SortOption(String visibleText, String value) {
        this.visibleText = visibleText;
        this.value = value;
    }

    public String getVisibleText() {
        return visibleText;
    }

    public String getValue() {
        return value;
    }
}