package birthday_selebration_01_02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthables = new ArrayList<>();
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String type = tokens[0];

            switch (type) {
                case "Citizen":
                    Citizen citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthables.add(citizen);
                    break;
                case "Robot":
                    Robot robot = new Robot(tokens[1], tokens[2]);
                    break;
                case "Pet":
                    Pet pet = new Pet(tokens[1], tokens[2]);
                    birthables.add(pet);
                    break;
            }

            line = scanner.nextLine();
        }
        String year = scanner.nextLine();
        birthables.stream().filter(b -> b.getBirthDate().endsWith(year)).forEach(birthable -> System.out.println(birthable.getBirthDate()));


    }
}

