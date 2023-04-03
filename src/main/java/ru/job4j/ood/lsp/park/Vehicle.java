package ru.job4j.ood.lsp.park;

public class Vehicle {
    private static int size = 1;
    private String carName;

    public Vehicle(int size, String carName) {
        this.size = size;
        this.carName = carName;
    }

    public int getSize() {
        return size;
    }

    public String getCarName() {
        return carName;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
