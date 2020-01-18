package vehicle_extentions_02;

public class Car extends VehicleImpl {
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption + SUMMER_CONSUMPTION, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        System.out.print("Car ");
        super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }

    @Override
    public void driveEmpty(double distance) {

    }

    @Override
    public String toString() {
        return "Car:" + super.toString();
    }

}
