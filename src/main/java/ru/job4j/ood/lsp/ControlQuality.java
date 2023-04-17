package ru.job4j.ood.lsp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    public ControlQuality() {
    }

    public void sort(List<AbstractStore> stores, Food food) {
        for (AbstractStore store : stores) {
            if (store.accept(food)) {
                store.add(food);
            }
        }
    }

    public void resort(List<AbstractStore> stores) {
        List<Food> foodList = new ArrayList<>();
        for (AbstractStore store : stores) {
            foodList.addAll(store.findAll());
        }
        for (Food food : foodList) {
            for (AbstractStore store : stores) {
                if (store.accept(food)) {
                    store.add(food);
                }
            }
        }
    }

    public static void main(String[] args) {
        ControlQuality controlQuality = new ControlQuality();
        Food food = new Food("Milk", LocalDateTime.now(), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food1 = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        AbstractStore wareHouse = new Warehouse();
        AbstractStore trash = new Trash();
        List<AbstractStore> stores = List.of(wareHouse, shop, trash);
        controlQuality.sort(stores, food);
        controlQuality.sort(stores, food1);
        controlQuality.resort(stores);
        System.out.println(wareHouse.findByName("Cheese"));
    }
}
