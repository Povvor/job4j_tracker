package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item right, Item left) {
        return left.getName().compareTo(right.getName());
    }
}
