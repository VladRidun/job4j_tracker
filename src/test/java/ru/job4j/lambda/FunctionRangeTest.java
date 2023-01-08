package ru.job4j.lambda;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;

import static org.hamcrest.MatcherAssert.assertThat;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FunctionRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadraticResults() {
        List<Double> result = FunctionRange.diapason(1, 5, x -> Math.pow(x, 2) + 2 * x + 4);
        List<Double> expected = Arrays.asList(7D, 12D, 19D, 28D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenDemonstrationResults() {
        List<Double> result = FunctionRange.diapason(1, 4, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(3D, 9D, 27D);
        assertThat(result, is(expected));
    }
}