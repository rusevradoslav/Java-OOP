package HotelReservation_04;

public enum Discount {
    None(0), SecondVisit(10), VIP(20);

    private final double discountPercets;

    Discount(int percents) {
        this.discountPercets = percents;
    }


    public double getDiscount() {
        return (100 - discountPercets) / 100.0;
    }
}
