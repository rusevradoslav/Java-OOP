package vehicle_01;

public class Car extends VehicleImpl {
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + SUMMER_CONSUMPTION);


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
    public String toString() {
        return "Car:" + super.toString();
    }
}
