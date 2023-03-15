package ru.job4j.kiss;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(maxMin.max(list, comparator)).isEqualTo(103);
    }

    @Test
    public void whenMin() {
        assertThat(maxMin.min(list, comparator)).isEqualTo(7);
    }

    @Test
    public void whenEmptyList() {
        List<Integer> emptyList = new ArrayList<>();
        assertThat(maxMin.min(emptyList, comparator)).isNull();
    }
}

