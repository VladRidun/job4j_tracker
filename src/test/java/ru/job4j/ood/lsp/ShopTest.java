package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class ShopTest {
    @Test
    void asserThatProductAccept() {
        Food food = new Food("Milk", LocalDateTime.now().minusMonths(2), LocalDateTime.now().plusMonths(1), 100.0, 10);
        AbstractStore shop = new Shop();
        shop.accept(food);
        assertThat(shop.accept(food)).isTrue();
    }

    @Test
    void asserThatProductNotAccept() {
        Food food = new Food("Cheese", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusDays(1), 100.0, 10);
        AbstractStore shop = new Shop();
        shop.accept(food);
        assertThat(shop.accept(food)).isFalse();
    }

    @Test
    void asserThatWhenPercentsMore75() {
        Food food = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food3 = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 90.0, 10);
        AbstractStore shop = new Shop();
        shop.accept(food);
        assertThat(shop.accept(food)).isTrue();
    }

    @Test
    void asserThatAcceptWhenPercentsMore75AndGetDiscount() {
        Food food = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 100.0, 10);
        Food food3 = new Food("Milk", LocalDateTime.now().minusDays(6), LocalDateTime.now().plusMonths(1), 90.0, 10);
        AbstractStore shop = new Shop();
        shop.accept(food);
        assertThat(food3.getPrice()).isEqualTo(food.getPrice());
    }
}