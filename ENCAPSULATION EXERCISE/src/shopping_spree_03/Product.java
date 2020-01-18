package shopping_spree_03;

import static someValidations.Validator.validateCost;
import static someValidations.Validator.validateName;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        setName(name);
        setCost(cost);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        validateCost(cost);
        this.cost = cost;
    }
}
