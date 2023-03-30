package ru.job4j.ood.lsp;

public class Shop extends AbstractStore {

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        var percentage = food.getPercentExpiration();
        if (percentage >= 25.0 && percentage <= 75.0) {
            rsl = true;
        } else if (percentage > 75.0 && !food.isExpired()) {
            setDiscount(food);
            rsl = true;
        }
        return rsl;
    }

    public void setDiscount(Food food) {
        food.applyDiscount();
    }
}
