package carTrip;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Car car;
    private static final double TANK_CAPACITY = 100;
    private static final double FUEL_AMOUNT = 50;
    private static final double FUEL_CONSUMPTION = 10;

    @Before

    public void creatingCar() {
        car = new Car("Tesla", TANK_CAPACITY, FUEL_AMOUNT, FUEL_CONSUMPTION);
    }

    @Test
    public void getModelShouldReturnModel() {
        Assert.assertEquals("Tesla", car.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidModelShouldThrowException() {
        car.setModel(null);
        car.setModel("");
    }


    @Test
    public void setModelShouldWorkCorrectly() {
        Assert.assertEquals(car.getModel(), "Tesla");
    }

    @Test
    public void getTankCapacityShouldReturnCapacity() {
        Assert.assertEquals(100, (long) car.getTankCapacity());
    }

    @Test
    public void getFuelAmountShouldReturnFuelAmount() {
        Assert.assertEquals(50, (long) car.getFuelAmount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelAmountShouldThrowException() {
        car.setFuelAmount(car.getFuelAmount() + 100);
    }

    @Test
    public void getFuelConsumptionShouldWorkCorrectly() {
        Assert.assertEquals(10, (long) car.getFuelConsumptionPerKm());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setFuelConsumptionShouldThrowException() {
        car.setFuelConsumptionPerKm(0);
        car.setFuelConsumptionPerKm(-1);
    }

    @Test
    public void driveMethodShouldWorkCorrectly() {
        car.drive(2);
        Assert.assertEquals(30, (long) car.getFuelAmount());
    }

    @Test(expected = IllegalStateException.class)
    public void driveMethodShouldThrowException() {
        car.drive(10);
    }

    @Test
    public void refuelMethodShouldWorkCorrectly() {
        car.refuel(20);
        Assert.assertEquals(70, (long) car.getFuelAmount());
    }

    @Test(expected = IllegalStateException.class)
    public void refuelMethodShouldThrowException() {
        car.refuel(100);
    }

}