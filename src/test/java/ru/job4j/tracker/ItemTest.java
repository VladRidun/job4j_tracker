package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void sortedByAsc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Third"),
                new Item(2, "First"),
                new Item(3, "Second")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item(2, "First"),
                new Item(3, "Second"),
                new Item(1, "Third")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void sortedByDesc() {
        List<Item> items = Arrays.asList(
                new Item(1, "Third"),
                new Item(2, "First"),
                new Item(3, "Second")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(1, "Third"),
                new Item(3, "Second"),
                new Item(2, "First")
        );
        assertThat(items).isEqualTo(expected);
    }
}