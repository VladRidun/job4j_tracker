package ru.job4j.ood.lsp;

public class Trash extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        return food.isExpired();
    }
}
