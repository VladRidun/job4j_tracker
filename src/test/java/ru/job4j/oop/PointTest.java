package ru.job4j.oop;


import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when20to00then2() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when42to23then2dot23() {
        double expected = 2.23;
        Point a = new Point(4, 2);
        Point b = new Point(2, 3);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when53to13then4() {
        double expected = 4;
        Point a = new Point(5, 3);
        Point b = new Point(1, 3);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when535to134then4dot12() {
        double expected = 4.12;
        Point a = new Point(5, 3, 5);
        Point b = new Point(1, 3, 4);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when121to378then8dot83() {
        double expected = 8.83;
        Point a = new Point(1, 2, 1);
        Point b = new Point(3, 7, 8);
        double out = a.distance3d(b);
        Assert.assertEquals(expected, out, 0.01);
    }
}