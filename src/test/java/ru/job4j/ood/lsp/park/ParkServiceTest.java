package ru.job4j.ood.lsp.park;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParkServiceTest {

    @Test
    public void whenCarAdded() throws Exception {
        Vehicle vehicleCar = new Vehicle(1, "Car");
        Parking parking = new Parking(4, 1);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar).isEqualTo(parking.find("Car"));
    }

    @Test
    public void whenTruckAdded() throws Parking.ParkingException {
        Vehicle vehicleTruck = new Vehicle(2, "Truck");
        Parking parking = new Parking(1, 3);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleTruck);
        assertThat(vehicleTruck).isEqualTo(parking.find("Truck"));
    }

    @Test
    public void whenAddCarSize1() throws Parking.ParkingException {
        Vehicle vehicleCar = new Vehicle(1, "Car");
        Parking parking = new Parking(10, 10);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar.getSize()).isEqualTo(parking.find("Car").getSize());
    }

    @Test
    public void whenAddTruckSize2() throws Parking.ParkingException {
        Vehicle vehicleTruck = new Vehicle(2, "Truck");
        Parking parking = new Parking(10, 10);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleTruck);
        assertThat(vehicleTruck.getSize()).isEqualTo(parking.find("Truck").getSize());
    }

    @Test
    public void whenAddCarSizeNull() {
        Vehicle vehicleCar1 = new Vehicle(0, "Car1");
        Parking parking = new Parking(1, 1);
        ParkService parkService = new ParkService();
        assertThatThrownBy(() -> parkService.park(parking, vehicleCar1)).
                isInstanceOf(Parking.ParkingException.class);
    }

    @Test
    public void whenNotAddCar() {
        Vehicle vehicleCar1 = new Vehicle(1, "Car1");
        Parking parking = new Parking(0, 0);
        ParkService parkService = new ParkService();
        assertThatThrownBy(() -> parkService.park(parking, vehicleCar1)).
                isInstanceOf(Parking.ParkingException.class);
    }

    @Test
    public void whenNotAddTruck() {
        Vehicle vehicleTruck = new Vehicle(3, "Truck");
        Parking parking = new Parking(1, 1);
        ParkService parkService = new ParkService();
        assertThatThrownBy(() -> parkService.park(parking, vehicleTruck)).
                isInstanceOf(Parking.ParkingException.class);
    }

    @Test
    public void whenAddTruckWhenTruckPackingIsFull() throws Parking.ParkingException {
        Vehicle vehicleCar = new Vehicle(4, "Truck");
        Parking parking = new Parking(10, 1);
        ParkService parkService = new ParkService();
        parkService.park(parking, vehicleCar);
        assertThat(vehicleCar.getCarName()).isEqualTo(parking.find("Truck").getCarName());
    }
}