package shopping_spree_03;

import java.util.LinkedList;
import java.util.List;

import static someValidations.Validator.validateCost;
import static someValidations.Validator.validateName;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new LinkedList<>();
    }

    private void setName(String name) {
        validateName(name);
        this.name = name;
    }

    private void setMoney(double money) {
        validateCost(money);
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product) throws IllegalArgumentException {
        if (this.money <= 0) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.getName(), product.getName()));
        }else {
            products.add(product);
            this.setMoney(this.getMoney() - product.getCost());
        }
    }
}
