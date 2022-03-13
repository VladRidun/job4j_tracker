package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] mass1 = o1.split("/");
        String[] mass2 = o2.split("/");
        int comp = mass2[0].compareTo(mass1[0]);
        if (comp == 0) {
            return o1.compareTo(o2);
        }
        return mass2[0].compareTo(mass1[0]);
    }
}