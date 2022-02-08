package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime date = item.getCreated();
        System.out.println(date.format(formatter));
        System.out.println();
        Item item1 = new Item(1, "Job1");
        System.out.println(item1);
    }
}