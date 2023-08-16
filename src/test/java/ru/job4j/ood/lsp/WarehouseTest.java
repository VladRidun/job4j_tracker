package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@Disabled
class WarehouseTest {

    @Test
    void asserThatProductAccept() {
        Food food = new Food("Milk", LocalDateTime.now().minusMonths(2), LocalDateTime.now().plusMonths(6), 100.0, 10);
        AbstractStore wareHouse = new Shop();
        wareHouse.accept(food);
        assertThat(wareHouse.accept(food)).isTrue();
    }

    @Test
    void asserThatProductNotAccept() {
        Food food = new Food("Cheese", LocalDateTime.now().minusDays(9), LocalDateTime.now(), 100.0, 10);
        AbstractStore wareHouse = new Shop();
        wareHouse.add(food);
        assertThat(wareHouse.accept(food)).isFalse();
    }
}