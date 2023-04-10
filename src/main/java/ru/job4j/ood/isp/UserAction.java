package ru.job4j.ood.isp;

public interface UserAction {
    String name();

    boolean execute(Menu menu, Input input);
}
