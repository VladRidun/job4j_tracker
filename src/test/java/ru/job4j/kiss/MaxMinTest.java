package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MaxMinTest {

    private static List<Integer> list;
    private static Comparator<Integer> comparator;
    private static MaxMin maxMin;

    @BeforeAll
    static void init() {
        maxMin = new MaxMin();
        comparator = Comparator.naturalOrder();
        list = new ArrayList<>(List.of(10, 103, 56, 7, 15, 12));
    }

    @Test
    public void whenMax() {
        int comp = maxMin.max(list, comparator);
        assertThat(maxMin.max(list, comparator), is(103));
    }

    @Test
    public void whenMin() {
        assertThat(maxMin.min(list, comparator), is(7));
    }

    @Test
    public void whenEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        assertNull(maxMin.min(emptyList, comparator));
    }
}