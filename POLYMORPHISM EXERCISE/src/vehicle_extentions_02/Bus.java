package vehicle_extentions_02;

public class Bus extends VehicleImpl {
    public Bus(double fuelQuantity, double consumption, double tankCapacity) {
        super(fuelQuantity, consumption, tankCapacity);
    }

    @Override
    public void drive(double distance) {
        System.out.print("Bus ");
        setConsumption(this.getConsumption() + 1.4);
        super.drive(distance);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters);
    }

    @Override
    public void driveEmpty(double distance) {
        System.out.print("Bus ");
        setConsumption(this.getConsumption());
        super.drive(distance);
    }

    @Override
    public String toString() {
        return "Bus:" + super.toString();
    }
}
