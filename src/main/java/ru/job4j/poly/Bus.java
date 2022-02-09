package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void toDrive() {
        System.out.println("Едет");
    }

    @Override
    public void getPassengers(int number) {
    }

    @Override
    public int toFuelUp(int countFuel, int price) {
        return countFuel * price;
    }
}
