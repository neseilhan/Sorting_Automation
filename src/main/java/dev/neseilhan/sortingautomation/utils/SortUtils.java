package dev.neseilhan.sortingautomation.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Utility class for sorting operations.
 *
 * <p>Provides helper methods for sorting lists of:
 * - Strings (alphabetically)
 * - Doubles (numerically)</p>
 *
 * This class is immutable and cannot be instantiated.
 *
 * @author Nese Ilhan
 * @version 1.0
 */
public class SortUtils {

    private SortUtils() {
    }

    /**
     * Sorts a list of strings in ascending order.
     *
     * @param source the original list
     * @return sorted list in ascending order
     */
    public static List<String> sortStringsAscending(List<String> source) {
        List<String> sortedList = new ArrayList<>(source);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * Sorts a list of strings in descending order.
     *
     * @param source the original list
     * @return sorted list in descending order
     */
    public static List<String> sortStringsDescending(List<String> source) {
        List<String> sortedList = new ArrayList<>(source);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    /**
     * Sorts a list of doubles in ascending order.
     *
     * @param source the original list
     * @return sorted list in ascending order
     */
    public static List<Double> sortDoublesAscending(List<Double> source) {
        List<Double> sortedList = new ArrayList<>(source);
        Collections.sort(sortedList);
        return sortedList;
    }

    /**
     * Sorts a list of doubles in descending order.
     *
     * @param source the original list
     * @return sorted list in descending order
     */
    public static List<Double> sortDoublesDescending(List<Double> source) {
        List<Double> sortedList = new ArrayList<>(source);
        sortedList.sort(Comparator.reverseOrder());
        return sortedList;
    }
}