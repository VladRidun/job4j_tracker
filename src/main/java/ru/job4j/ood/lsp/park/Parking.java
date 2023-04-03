package ru.job4j.ood.lsp.park;

import java.util.ArrayList;
import java.util.List;

public class Parking implements CarStore {
    private int sizeCars;
    private int sizeTrucks;
    private List<Vehicle> carList = new ArrayList<>();
    private List<Vehicle> truckList = new ArrayList<>();

    public List<Vehicle> getCarList() {
        return carList;
    }

    public void setCarList(List<Vehicle> carList) {
        this.carList = carList;
    }

    public List<Vehicle> getTruckList() {
        return truckList;
    }

    public void setTruckList(List<Vehicle> truckList) {
        this.truckList = truckList;
    }

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
        Vehicle rsl = null;
        for (Vehicle vehicleCar : carList) {
            if (key.equals(vehicleCar.getCarName())) {
                rsl = vehicleCar;
            }
        }
        if (rsl == null) {
            for (Vehicle vehicleCar : truckList) {
                if (key.equals(vehicleCar.getCarName())) {
                    rsl = vehicleCar;
                }
            }
        }
        return rsl;
    }

    @Override
    public void add(Vehicle vehicle) throws ParkingException {
        if (vehicle.getSize() == 1 && sizeCars >= vehicle.getSize()) {
            carList.add(vehicle);
            sizeCars -= vehicle.getSize();
        } else if (vehicle.getSize() > 1 && sizeTrucks >= vehicle.getSize()) {
            truckList.add(vehicle);
            sizeTrucks -= vehicle.getSize();
        } else if (sizeCars >= vehicle.getSize() && vehicle.getSize() > 1) {
            carList.add(vehicle);
            sizeCars -= vehicle.getSize();
        } else if (vehicle.getSize() > sizeCars && vehicle.getSize() > sizeTrucks) {
            throw new ParkingException("На стоянке нет места!");
        } else if (vehicle.getSize() == 0) {
            throw new ParkingException("Размер машины не должен быть равен 0!");
        }
    }

    static class ParkingException extends Exception {
        public ParkingException(String message) {
            super(message);
        }
    }
}
