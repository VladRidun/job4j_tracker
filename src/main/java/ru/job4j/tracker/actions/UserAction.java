package ru.job4j.tracker.actions;

import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
