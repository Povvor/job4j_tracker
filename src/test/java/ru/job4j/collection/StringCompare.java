package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        int length = Integer.min(left.length(), right.length());
        int compareStatus;
        while (i < length) {
            compareStatus = Character.compare(left.charAt(i), right.charAt(i));
            if (compareStatus != 0) {
                return compareStatus;
            }
            i++;
        }
        return Integer.compare(left.length(), right.length());
    }
}
