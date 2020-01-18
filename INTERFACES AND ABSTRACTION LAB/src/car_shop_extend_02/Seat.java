package car_shop_extend_02;

public class Seat extends CarImpl implements Sellable {
    private Double price;

    public Seat(String model, String color, Integer horsepower, String country, Double price) {
        super(model, color, horsepower, country);
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Leon sells for %f", getPrice()))
                .append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
