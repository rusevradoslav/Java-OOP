package vehicle_01;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {
    private double fuelQuantity;
    private double consumption;
    DecimalFormat formater = new DecimalFormat("#.##");

    protected VehicleImpl(double fuelQuantity, double consumption) {
        setFuelQuantity(fuelQuantity);
        setConsumption(consumption);

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getConsumption() {
        return consumption;
    }

    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    @Override
    public void drive(double distance) {
        if (fuelQuantity > consumption * distance) {
            fuelQuantity -= consumption * distance;
            System.out.println(String.format("travelled %s km", formater.format(distance)));
        } else {
            System.out.println("needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format(" %.2f", getFuelQuantity());
    }
}
