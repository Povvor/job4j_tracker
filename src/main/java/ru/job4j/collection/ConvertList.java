package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] listNum : list) {
            for (int number : listNum) {
                result.add(number);
            }
        }
        return result;
    }
}