package ru.job4j.ood.lsp.park;

public class ParkService {
    public void park(Parking parking, Vehicle vehicle) throws Parking.ParkingException {
         parking.add(vehicle);
    }
}
