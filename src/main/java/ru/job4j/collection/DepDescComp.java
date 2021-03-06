package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] mass1 = o1.split("/");
        String[] mass2 = o2.split("/");
        int comp = mass2[0].compareTo(mass1[0]);
        return comp != 0 ? comp : o1.compareTo(o2);
    }
}