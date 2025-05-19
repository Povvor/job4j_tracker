package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item right, Item left) {
        return right.getName().compareTo(left.getName());
    }
}
