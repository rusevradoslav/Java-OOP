package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long starCounter = 0l;
        int[] dimestions = integerDimensions(scanner.nextLine());
        Galaxy galaxy = new Galaxy(dimestions[0], dimestions[1]);


        long starCollection = 0;
        while (true) {
            String command = scanner.nextLine();

            if (command.equals("Let the Force be with you")) {
                break;
            }
            int[] playerPosition = integerDimensions(command);
            int[] enemyPosition = integerDimensions(scanner.nextLine());
            Player player = new Player(playerPosition[0], playerPosition[1]);
            Enemy enemy = new Enemy(enemyPosition[0], enemyPosition[1]);

            while (enemy.getRow() >= 0 && enemy.getCol() >= 0) {
                if (galaxy.isValid(enemy.getRow(), enemy.getCol())) {
                    galaxy.enemyStar(enemy.getRow(), enemy.getCol());
                }
                enemy.moveEnemy();
            }


            while (player.getRow() >= 0 && player.getCol() < galaxy.getColLength()) {
                if (galaxy.isValid(player.getRow(), player.getCol())) {
                    starCollection += galaxy.getStarValue(player.getRow(), player.getCol());
                }

                player.movePlayer();
            }


            System.out.println(starCollection);


        }
    }

    private static int[] integerDimensions(String s) {
        return Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
