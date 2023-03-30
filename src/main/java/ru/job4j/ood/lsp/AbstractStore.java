package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractStore implements Store {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void add(Food food) {
        foods.add(food);
    }

    @Override
    public boolean delete(String key) {
        boolean rsl = false;
        Iterator<Food> iterator = foods.iterator();
        while (iterator.hasNext()) {
            Food food = iterator.next();
            if (key.equals(food.getName())) {
                iterator.remove();
            }
        }
        return rsl;
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<Food>(foods);
    }

    @Override
    public Food findByName(String key) {
        Food rsl = null;
        for (Food food : foods) {
            if (key.equals(food.getName())) {
                rsl = food;
            }
        }
        return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return false;
    }

    @Override
    public void close() throws Exception {

    }

}