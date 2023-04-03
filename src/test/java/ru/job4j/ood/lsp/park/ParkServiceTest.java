package ru.job4j.ood.lsp.park;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class ParkServiceTest {

    @Test
    public void whenCarAdded() {
        Vehicle vehicleCar = new Vehicle(1, "Car");
        Parking parking = new Parking(4, 1);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar).isEqualTo(parking.find("Car"));
    }

    @Test
    public void whenTruckAdded() {
        Vehicle vehicleTruck = new Vehicle(2, "Truck");
        Parking parking = new Parking(1, 3);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleTruck);
        assertThat(vehicleTruck).isEqualTo(parking.find("Truck"));
    }

    @Test
    public void whenAddCarSize1() {
        Vehicle vehicleCar = new Vehicle(1, "Car");
        Parking parking = new Parking(10, 10);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar.getSize()).isEqualTo(parking.find("Car").getSize());
    }

    @Test
    public void whenAddTruckSize2() {
        Vehicle vehicleTruck = new Vehicle(2, "Truck");
        Parking parking = new Parking(10, 10);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleTruck);
        assertThat(vehicleTruck.getSize()).isEqualTo(parking.find("Truck").getSize());
    }

    @Test
    public void whenAddCarSizeNull() {
        assertThatThrownBy(() -> new Vehicle(0, "Car")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenNotAddCar() {
        Vehicle vehicleCar1 = new Vehicle(1, "Car1");
        Vehicle vehicleCar2 = new Vehicle(1, "Car2");
        Parking parking = new Parking(1, 1);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar1);
        var expResult = "На стоянке нет места.\n";
        assertEquals(expResult, (parkService.park(parking, vehicleCar2)));
    }

    @Test
    public void whenNotAddTruck() {
        Vehicle vehicleTruck = new Vehicle(3, "Truck");
        Parking parking = new Parking(1, 1);
        ParkService parkService = new ParkService();
        var expResult = "На стоянке нет места.\n";
        assertEquals(expResult, (parkService.park(parking, vehicleTruck)));
    }

    @Test
    public void whenAddTruckWhenTruckPackingIsFull() {
        Vehicle vehicleCar = new Vehicle(4, "Truck");
        Parking parking = new Parking(10, 1);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar.getSize()).isEqualTo(parking.find("Truck").getSize());
    }
}