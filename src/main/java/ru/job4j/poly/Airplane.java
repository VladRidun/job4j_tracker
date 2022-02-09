package ru.job4j.poly;

public class Airplane implements Vehicle {
    @Override
    public void toMove() {
        System.out.println(getClass().getSimpleName() + "летает по воздуху");
    }
}
