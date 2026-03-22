package dev.neseilhan.sortingautomation.constants;

public enum SortOption {

    NAME_ASC("Name (A to Z)", "az"),
    NAME_DESC("Name (Z to A)", "za"),
    PRICE_LOW_TO_HIGH("Price (low to high)", "lohi"),
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