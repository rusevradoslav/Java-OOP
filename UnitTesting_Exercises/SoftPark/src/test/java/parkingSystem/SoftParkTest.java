package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;

public class SoftParkTest {
    SoftPark parking;
    Car car;

    @Before
    public void cratingSoftPark() {
        parking = new SoftPark();
        car = new Car("Audi", "CA 1111 CA");
    }

    @Test
    public void creatingConstructorWorkCorrectly() {
        Assert.assertEquals(12, parking.getParking().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldGetParkingMethodThrowExceptionWhenItCalled() {
        parking.getParking().remove(car);
        // parking.getParking().clear();
        //should throw exception because the collection is UNMODIFIABLE
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkSpotDoesntExists() {
        parking.parkCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkSpotIsAlreadyTaken() {
        Car carTwo = new Car("BMW", "CA 5555 CA");
        parking.parkCar("A1", car);
        parking.parkCar("A1", carTwo);
    }

    @Test
    public void carIsParkCorrectlyInParking() {
        parking.parkCar("A1", car);
        Assert.assertEquals("CA 1111 CA", parking.getParking().get("A1").getRegistrationNumber());
    }

    @Test
    public void putCarShouldWorkCorrectlyMessageTest() {
        String result = parking.parkCar("A1", car);
        Assert.assertEquals("Car:CA 1111 CA parked successfully!", result);
    }


    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkSpotDoesntExists() {
        parking.removeCar("W1", car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkSpotIsAlreadyTaken() {
        Car carTwo = new Car("BMW", "CA 5555 CA");
        parking.parkCar("A1", car);
        parking.removeCar("A1", carTwo);
    }

    @Test
    public void removeCarShouldWorkCorrectly() {
        parking.parkCar("A1", car);
        parking.removeCar("A1", car);
        // Assert.assertNull(parking.getParking().get("A1"));
        Assert.assertEquals(null, parking.getParking().get("A1"));
    }

    @Test
    public void removeCarShouldWorkCorrectlyMessageTest() {
        parking.parkCar("A1", car);
        String result = parking.removeCar("A1", car);
        Assert.assertEquals("Remove car:CA 1111 CA successfully!", result);
    }
}