package dev.neseilhan.sortingautomation.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtils {

    private SortUtils() {
    }

    public static List<String> sortStringsAscending(List<String> source) {
        List<String> sortedList = new ArrayList<>(source);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static List<String> sortStringsDescending(List<String> source) {
        List<String> sortedList = new ArrayList<>(source);
        sortedList.sort(Collections.reverseOrder());
        return sortedList;
    }

    public static List<Double> sortDoublesAscending(List<Double> source) {
        List<Double> sortedList = new ArrayList<>(source);
        Collections.sort(sortedList);
        return sortedList;
    }

    public static List<Double> sortDoublesDescending(List<Double> source) {
        List<Double> sortedList = new ArrayList<>(source);
        sortedList.sort(Comparator.reverseOrder());
        return sortedList;
    }
}