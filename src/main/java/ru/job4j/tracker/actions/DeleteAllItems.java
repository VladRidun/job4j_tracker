package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

import java.util.List;

public class DeleteAllItems implements UserAction {

    @Override
    public String name() {
        return "=== Delete all items ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> allItems = tracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        System.out.println("=== Все заявки удалены ===");
        return true;
    }

}
