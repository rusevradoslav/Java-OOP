package car_shop_extend_02;

public class CarImpl implements Car {
    String model;
    String color;
    Integer horsepower;
    String country;

    public CarImpl(String model, String color, Integer horsepower, String country) {
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
        this.country = country;
    }

    @Override
    public String getModel() {
        return  this.model;
    }

    @Override
    public String getColor() {
        return  this.color;
    }

    @Override
    public Integer getHorsePower() {
        return  this.horsepower;
    }

    @Override
    public String countryProduced() {
        return this.country;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires", getModel(),countryProduced(),this.TIRES);
        }
    }


