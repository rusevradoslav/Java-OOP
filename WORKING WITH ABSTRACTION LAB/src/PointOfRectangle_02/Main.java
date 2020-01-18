package PointOfRectangle_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rectangleInput = scanner.nextLine().split("\\s+");

        int[] coordinates = new int[4];

        for (int i = 0; i < 4; i++) {
            coordinates[i] = Integer.parseInt(rectangleInput[i]);
        }

        Rectangle rectangle = new Rectangle(coordinates[0], coordinates[1], coordinates[2], coordinates[3]);

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            int X = Integer.parseInt(tokens[0]);
            int Y = Integer.parseInt(tokens[1]);
            Point point = new Point(X, Y);
            System.out.println(rectangle.contains(point));
        }
    }
}
