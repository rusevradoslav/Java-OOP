package TrafficLights_04;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TrafficLight[] lights = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(e -> new TrafficLight(Signal.valueOf(e)))
                .toArray(TrafficLight[]::new);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j].changeSignal();
                sb.append(lights[j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString().trim());
    }


}
