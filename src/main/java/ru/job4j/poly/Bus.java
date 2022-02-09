package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void toDrive() {
        System.out.println("Едет");
    }

    @Override
    public int getPassengers(int number) {
        return 0;
    }

    @Override
    public int toFuelUp(int countFuel, int price) {
        return countFuel * price;
    }
}
