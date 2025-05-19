package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {
    @Test
    void sortTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "first"),
                new Item(2, "Second"),
                new Item(3, "third"),
                new Item(3, "Fourth")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(3, "Fourth"),
                new Item(2, "Second"),
                new Item(1, "first"),
                new Item(3, "third")

        );
        assertThat(items).isEqualTo(expected);

    }

}