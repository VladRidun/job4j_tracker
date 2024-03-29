package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int expected = 2;
        assertThat(Max.max(1, 2)).isEqualTo(expected);
    }

    @Test
    public void whenMax3To5To7Then7() {
        int expected = 7;
        assertThat(Max.max(3, 5, 7)).isEqualTo(expected);
    }

    @Test
    public void whenMax9To5To4To7Then9() {
        int expected = 9;
        assertThat(Max.max(9, 5, 4, 7)).isEqualTo(expected);
    }
}