package ru.job4j.oop;

public class Max {
    public static int max(int fisrt, int second) {
        return fisrt > second ? fisrt : second;
    }

    public static int max(int fisrt, int second, int third) {
        return max(fisrt, max(second, third));
    }

    public static int max(int fisrt, int second, int third, int fourth) {
        return max(fourth, max(fisrt, max(second, third)));
    }
}