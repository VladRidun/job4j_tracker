package ru.job4j.ood.lsp.park;

public interface CarStore {
    Vehicle find(String key);

    void add(Vehicle vehicle);
}
