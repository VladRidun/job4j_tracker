package ru.job4j.ood.lsp.park;

public class Parking implements CarStore {
   private int sizeCars;
    private int sizeTrucks;

    public Parking(int sizeCars, int sizeTrucks) {
        this.sizeCars = sizeCars;
        this.sizeTrucks = sizeTrucks;
    }

    public int getSizeCars() {
        return sizeCars;
    }

    public void setSizeCars(int sizeCars) {
        this.sizeCars = sizeCars;
    }

    public int getSizeTrucks() {
        return sizeTrucks;
    }

    public void setSizeTrucks(int sizeTrucks) {
        this.sizeTrucks = sizeTrucks;
    }

    @Override
    public Vehicle find(String key) {
        return null;
    }

    @Override
    public void add(Vehicle vehicle) {

    }
}
