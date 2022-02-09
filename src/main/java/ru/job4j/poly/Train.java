package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void toMove() {
        System.out.println(getClass().getSimpleName() + "передвигается по рельсам");
    }
}
