package RhombusOfStars_01;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= size; i++) {
            printRow(size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            printRow(size, i);

        }

    }

    private static void printRow(int size, int i) {
        printSpaces(i, size);
        printStars(i);
        System.out.println();
    }

    private static void printStars(int rowCount) {
        for (int i = 0; i < rowCount; i++) {
            System.out.print("* ");
        }
    }

    private static void printSpaces(int row, int size) {
        int spaceCount = Math.abs(size - row);
        for (int i = 0; i < spaceCount; i++) {
            System.out.print(" ");
        }
    }

}
