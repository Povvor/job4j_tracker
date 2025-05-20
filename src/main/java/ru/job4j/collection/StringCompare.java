package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int length = Integer.min(left.length(), right.length());
        int compareStatus;
        for (int i = 0; i < length; i++) {
            compareStatus = Character.compare(left.charAt(i), right.charAt(i));
            if (compareStatus != 0) {
                return compareStatus;
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}
