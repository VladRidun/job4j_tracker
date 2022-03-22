package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        String[] strings = {
                "image111",
                "image3",
                "image22"
        };
        Comparator<String> cmpText = String::compareTo;
        Comparator<String> cmpDescSize = (left, right) -> Integer.compare(right.length(), left.length());

        Arrays.sort(strings, cmpText);
        for (String s : strings) {
            System.out.println(s);
        }

        Arrays.sort(strings, cmpDescSize);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}