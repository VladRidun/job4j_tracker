package ru.job4j.poly;

public interface Transport {

    void toDrive();

    int getPassengers(int number);

    int toFuelUp(int countFuel, int price);
}