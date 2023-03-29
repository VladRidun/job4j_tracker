package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public Food add(Food food) {
        foods.add(food);
        return food;
    }

    @Override
    public boolean delete(String key) {
        boolean rsl = false;
        for (Food food : foods) {
            if (key.equals(food.getName())) {
                foods.remove(food);
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public List<Food> findAll() {
        return new ArrayList<Food>(foods);
    }

    @Override
    public List<Food> findByName(String key) {
        List<Food> rsl = new ArrayList<>();
        for (Food food : foods) {
            if (key.equals(food.getName())) {
                rsl.add(food);
            }
        }
        return rsl;
    }

    @Override
    public void close() throws Exception {

    }

}
