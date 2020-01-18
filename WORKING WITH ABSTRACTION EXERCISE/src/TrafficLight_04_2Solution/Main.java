package TrafficLight_04_2Solution;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Signal[] signal = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(e -> Signal.valueOf(e))
                .toArray(Signal[]::new);

        int n = Integer.parseInt(scanner.nextLine());

        Signal[] light = Signal.values();

        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < signal.length; i++) {
                int index = (signal[i].ordinal() + 1) % light.length;
                signal[i] = light[index];
                sb.append(signal[i].toString() + " ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }
}

