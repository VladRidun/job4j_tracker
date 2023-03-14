package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> values, Comparator<T> comparator) {
        return null;
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        return null;
    }

    public static <T> T maxMin(List<T> values, Predicate<T> predicate) {
        if (values.isEmpty()) {
            return null;
        }
        T rsl = values.get(0);
        for (T value : values) {
            if (predicate.test(value)) {
                rsl = value;
            }
        }
        return rsl;
    }
}
