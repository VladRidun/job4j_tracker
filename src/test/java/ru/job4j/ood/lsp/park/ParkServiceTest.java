package ru.job4j.ood.lsp.park;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@Disabled
class ParkServiceTest {

    @Test
    public void whenCarAdded() {
        Vehicle vehicleCar = new Vehicle();
        Parking parking = new Parking();
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar).isEqualTo(parking.find("Car"));
    }

    @Test
    public void whenTruckAdded() {
        Vehicle vehicleTruck = new Vehicle();
        Parking parking = new Parking();
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleTruck);
        assertThat(vehicleTruck).isEqualTo(parking.find("Truck"));
    }

}