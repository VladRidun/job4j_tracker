package ru.job4j.ex;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    public void whenFactGetMinusNumberAndFinish() {
        assertThrows(IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-1);
                });
    }
}