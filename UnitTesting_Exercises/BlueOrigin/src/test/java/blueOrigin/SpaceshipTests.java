package blueOrigin;


import net.bytebuddy.build.ToStringPlugin.Enhance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpaceshipTests {

    Spaceship spaceship;
    Astronaut astronaut;

    @Before
    public void creatingSpaceShip() {
        spaceship = new Spaceship("Rocket", 2);
        astronaut = new Astronaut("Pesho", 10);

    }

    @Test
    public void spaceShipConstructorShouldWorkCorrectly() {
        Assert.assertEquals("Rocket", spaceship.getName());
        Assert.assertEquals(2, 2);
    }

    @Test(expected = NullPointerException.class)
    public void invalidSpaceShipNameShouldThrowException() {
        spaceship = new Spaceship(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidSpaceShipCapacityShouldThrowException() {
        spaceship = new Spaceship("Rocket", -1);
    }

    @Test
    public void addMethodShouldWorkCorrectly() {
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMethodShouldNotAddingAstronautsWhenHaveNoMoreCapacity() {
        Spaceship spaceship = new Spaceship("Rocket", 0);
        spaceship.add(astronaut);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionIfAstronautExist() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test
    public void removeMethodShouldWorkCorrectly() {
        spaceship.add(astronaut);
        boolean isRemoved = spaceship.remove("Pesho");
        int currentCount = spaceship.getCount();
        Assert.assertTrue(isRemoved);
        Assert.assertEquals(0, currentCount);
    }

}
