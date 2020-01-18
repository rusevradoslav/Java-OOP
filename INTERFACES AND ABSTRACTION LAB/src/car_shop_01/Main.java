package car_shop_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car seat = new Seat("Leon", "gray", 100, "Bulgaria");
        System.out.println(String.format("%s is %s color and have %s horse power", seat.getModel(), seat.getColor(), seat.getHorsePower()));
        System.out.println(seat.toString());

    }
}
