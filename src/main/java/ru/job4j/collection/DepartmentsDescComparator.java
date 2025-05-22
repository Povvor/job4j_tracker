package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] splitLeft = left.split("/");
        String[] splitRight = right.split("/");
        int result = splitRight[0].compareTo(splitLeft[0]);
        if (result != 0) {
            return result;
        }
        return left.compareTo(right);
    }
}