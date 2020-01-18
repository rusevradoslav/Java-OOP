package CardSuit_01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println(line + ":");

        Arrays.stream(Suit.values()).forEach(e -> System.out.println(e.toString()));
    }
}
