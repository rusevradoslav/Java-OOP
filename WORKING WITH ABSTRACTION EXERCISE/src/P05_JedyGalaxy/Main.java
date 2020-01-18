package P05_JedyGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long starCounter = 0l;
        int[] matrixDetails = integerDimensions(scanner.nextLine());
        Galaxy galaxy = new Galaxy(matrixDetails[0], matrixDetails[1]);

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("Let the Force be with you")) {
                break;
            }

            int[] heroCoordinates = integerDimensions(line);
            Hero hero = new Hero(heroCoordinates[0], heroCoordinates[1]);

            line = scanner.nextLine();
            int[] evilCoordinates = integerDimensions(line);
            Evil evil = new Evil(evilCoordinates[0], evilCoordinates[1]);

            while (evil.getRowCoordinate() >= 0 && evil.getColCoordinate() >= 0) {
                if (galaxy.isValid(evil.getRowCoordinate(), evil.getColCoordinate())) {
                    galaxy.evilStar(evil.getRowCoordinate(), evil.getColCoordinate());
                }
                evil.moveEvil();
            }

            while (hero.getRowCoordinate() >= 0 && hero.getColCoordinate() < galaxy.getColLength()) {
                if (galaxy.isValid(hero.getRowCoordinate(), hero.getColCoordinate())) {
                    starCounter += galaxy.getStarValue(hero.getRowCoordinate(), hero.getColCoordinate());
                }
                hero.moveHero();
            }

        }

        System.out.println(starCounter);

    }

    private static int[] integerDimensions(String line) {
        return Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
