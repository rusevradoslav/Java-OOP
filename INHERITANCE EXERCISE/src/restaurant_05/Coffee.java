package restaurant_05;

import java.math.BigDecimal;

public class Coffee extends HotBeverage {
    private final static double COFFEE_MILLILITERS = 50;
    private final static BigDecimal COFFEE_PRICE = BigDecimal.valueOf(3.50);
    private double caffeine;


    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public static double getCoffeeMilliliters() {
        return COFFEE_MILLILITERS;
    }

    public static BigDecimal getCoffeePrice() {
        return COFFEE_PRICE;
    }

    public double getCaffeine() {
        return caffeine;
    }

    public void setCaffeine(double caffeine) {
        this.caffeine = caffeine;
    }
}
