package ru.job4j.oop;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.oop.Max;

public class MaxTest {

    @Test
    public void whenMax1To2Then2() {
        int expected = 2;
        Assert.assertEquals(Max.max(1, 2), expected);
    }

    @Test
    public void whenMax3To5To7Then7() {
        int expected = 7;
        Assert.assertEquals(Max.max(3, 5, 7), expected);
    }

    @Test
    public void whenMax9To5To4To7Then9() {
        int expected = 9;
        Assert.assertEquals(Max.max(9, 5, 4, 7), expected);
    }
}