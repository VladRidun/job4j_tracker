package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] charL = left.split("\\.", 2);
        String[] charR = right.split("\\.", 2);
        int numberL = Integer.parseInt(charL[0]);
        int numberR = Integer.parseInt(charR[0]);
        return Integer.compare(numberL, numberR);
    }
}
