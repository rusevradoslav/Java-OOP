package vehicle_extentions_02;

import java.text.DecimalFormat;

public abstract class VehicleImpl implements Vehicle {

    private double fuelQuantity;
    private double consumption;
    private double tankCapacity;
    DecimalFormat formater = new DecimalFormat("#.##");

    public VehicleImpl(double fuelQuantity, double consumption, double tankCapacity) {
        setFuelQuantity(fuelQuantity);
        setConsumption(consumption);
        setTankCapacity(tankCapacity);
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

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
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
        if (liters <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        } else {
            if (tankCapacity > fuelQuantity + liters) {
                this.fuelQuantity += liters;
            } else {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }


        }
    }
    @Override
    public String toString() {
        return String.format(" %.2f", getFuelQuantity());
    }
}
