package vehicle_01;

public class Truck extends VehicleImpl {
    private static final double SUMMER_CONSUMPTION_TRUCK = 1.6;

    public Truck(double fuelQuantity, double consumption) {
        super(fuelQuantity, consumption + SUMMER_CONSUMPTION_TRUCK);

    }

    @Override
    public void drive(double distance) {
        System.out.print("Truck ");
        super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }

    @Override
    public String toString() {
        return "Truck:" + super.toString();
    }
}
