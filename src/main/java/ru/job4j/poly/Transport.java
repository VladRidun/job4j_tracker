package ru.job4j.poly;

public interface Transport {

    void toDrive();

    void getPassengers(int count);

    int toFuelUp(int countFuel, int price);
}