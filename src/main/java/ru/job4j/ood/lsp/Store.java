package ru.job4j.ood.lsp;

import java.util.List;

public interface Store extends AutoCloseable {
    Food add(Food food);

    boolean delete(String key);

    List<Food> findAll();

    List<Food> findByName(String key);
}