package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int localSize = 0;
        Item[] result = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                result[localSize] = items[i];
                System.out.println(i);
                localSize++;
            }
        }
        result = Arrays.copyOf(result, localSize);
        return result;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int target = indexOf(id);
        if (target == -1) {
            System.out.println("Данного id не существует!");
            return false;
        } else {
            items[target] = item;
            items[target].setId(id);
            return true;
        }
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        int localSize = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                result[localSize] = items[i];
                localSize++;
            }
        }
        result = Arrays.copyOf(result, localSize);
        return result;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int length = size - index - 1;
            System.arraycopy(items, index + 1, items, index, length);
            items[size - 1] = null;
            size--;
        } else {
            System.out.println("Данного id не существует!");
        }

    }
}

