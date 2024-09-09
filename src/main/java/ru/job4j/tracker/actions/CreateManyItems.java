package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.store.Store;

public class CreateManyItems implements UserAction {

    @Override
    public String name() {
        return "=== Create many items ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        System.out.println("Добавлено заявок: " + count);
        return true;
    }

}
