package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.IntPredicate;

public class MaxMin {
    public <T> T max(List<T> values, Comparator<T> comparator) {
        return maxMin(values, comparator, (i -> i > 0));
    }

    public <T> T min(List<T> values, Comparator<T> comparator) {
        return maxMin(values, comparator, (i -> i < 0));
    }

    public static <T> T maxMin(List<T> values, Comparator<T> comparator, IntPredicate predicate) {
        T rsl = values.isEmpty() ? null : values.get(0);
        for (T value : values) {
            if (predicate.test(comparator.compare(value, rsl))) {
                rsl = value;
            }
        }
        return rsl;
    }
}
