package hell;

import hell.interfaces.Hero;
import hell.interfaces.Manager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Manager manager = new ManagerImpl();


        String command = scanner.nextLine();

        while (!command.equals("Quit")) {
            String result = "";
            String[] commandArgs = command.split(" ");
            switch (commandArgs[0]) {
                case "Hero":
                    result = manager.addHero(Arrays.asList(commandArgs[1], commandArgs[2]));
                    break;
                case "Item":
                    result = manager.addItem(Arrays.asList(commandArgs));
                    break;
                case "Recipe":
                    result = manager.addRecipe(Arrays.asList(commandArgs));
                    break;
                case "Inspect":
                    result = manager.inspect(Arrays.asList(commandArgs));

            }


            System.out.println(result);


            command = scanner.nextLine();
        }

        System.out.println(manager.quit());

    }
}