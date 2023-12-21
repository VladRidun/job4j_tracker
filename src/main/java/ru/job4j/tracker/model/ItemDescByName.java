package ru.job4j.tracker.model;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return second.getName().compareTo(first.getName());
    }
}
