package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void toDrive() {
        System.out.println("Едет");
    }

    @Override
    public void getPassengers(int count) {
    }

    @Override
    public int toFuelUp(int countFuel, int price) {
        return countFuel * price;
    }

    @Override
    public void toMove() {
        System.out.println(getClass().getSimpleName() + "двигается по скоростным трассам");
    }
}
