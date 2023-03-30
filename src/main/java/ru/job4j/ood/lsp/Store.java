package ru.job4j.ood.lsp;

import java.util.List;

public interface Store extends AutoCloseable {
    void add(Food food);

    boolean delete(String key);

    List<Food> findAll();

    Food findByName(String key);

    boolean accept(Food food);

}