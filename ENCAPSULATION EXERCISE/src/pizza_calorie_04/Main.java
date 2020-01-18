package pizza_calorie_04;

import java.util.Scanner;

public class Main {
    private static Pizza pizza;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String[] pizzaData = scanner.nextLine().split("\\s+");
            pizza = new Pizza(pizzaData[1], Integer.parseInt(pizzaData[2]));
            String[] doughData = scanner.nextLine().split("\\s+");
            Dough dough = new Dough(doughData[1], doughData[2], Double.parseDouble(doughData[3]));
            pizza.setDough(dough);

            String line = scanner.nextLine();
            while (!line.equals("END")) {
                String[] tokens = line.split("\\s+");
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);
                line = scanner.nextLine();
                System.out.println(pizza.getName() + " - " + pizza.getOverallCalories());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }




    }
}