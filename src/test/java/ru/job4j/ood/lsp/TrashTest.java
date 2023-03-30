package ru.job4j.ood.lsp;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class TrashTest {
    @Test
    void asserThatProductAccept() {
        AbstractStore trash = new Trash();
        Food food = new Food("Milk", LocalDateTime.now(), LocalDateTime.now().minusDays(5), 100.0, 10);
        assertThat(trash.accept(food)).isTrue();
    }

    @Test
    void asserThatTheProductNotAccept() {
        AbstractStore trash = new Trash();
        Food food = new Food("Milk", LocalDateTime.now().minusDays(2), LocalDateTime.now().plusDays(1), 100.0, 10);
        trash.accept(food);
        assertThat(trash.accept(food)).isFalse();
    }

}