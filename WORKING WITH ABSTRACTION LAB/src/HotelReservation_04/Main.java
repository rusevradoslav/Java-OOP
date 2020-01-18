package HotelReservation_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");

        double pricePerNight = Double.parseDouble(line[0]);
        int numberOfDays = Integer.parseInt(line[1]);
        String seasonName = line[2];
        String discountType = line[3];
        Season season = Season.valueOf(seasonName);
        Discount discount = Discount.valueOf(discountType);

        double result = getPriceFor(pricePerNight, numberOfDays, season, discount);
        System.out.printf("%.2f", result);
    }

    private static double getPriceFor(double pricePerNight, int numberOfDays, Season season, Discount discount) {
        return pricePerNight * season.getIndex() * numberOfDays * discount.getDiscount();
    }
}
