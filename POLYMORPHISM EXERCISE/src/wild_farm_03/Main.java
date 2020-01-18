package wild_farm_03;



import wild_farm_03.animal.*;
import wild_farm_03.food.Food;
import wild_farm_03.food.Meat;
import wild_farm_03.food.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AnimalImpl animal = null;
        List<AnimalImpl> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");

            String type = tokens[0];
            String name = tokens[1];
            Double weight = Double.parseDouble(tokens[2]);
            String livingRegion = tokens[3];
            switch (type){
                case "Cat":
                    String breed = tokens[4];
                    animal = new Cat(name,type,weight, livingRegion,breed);
                    break;
                case "Tiger":
                    animal = new Tiger(name,type,weight,livingRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(name,type,weight,livingRegion);
                    break;
                case "Mouse":
                    animal = new Mouse(name,type,weight,livingRegion);
                    break;
            }
            animals.add(animal);

            String[] foodTokens = scanner.nextLine().split("\\s+");
            if (foodTokens[0].equals("End")){
                break;
            }
            Food food = null;
            switch (foodTokens[0]){
                case "Meat":
                    food = new Meat(Integer.parseInt(foodTokens[1]));
                    break;
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodTokens[1]));
                    break;
                default:
                    System.out.println(type + "are not eating that type of food!");
                    input = scanner.nextLine();
                    continue;
            }

            animals.get(animals.size() - 1).makeSound();
            assert animal != null;
            animal.eat(food);

            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }
}



//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String input = bufferedReader.readLine();
//
//        int counter = 0;
//        Animal animal = null;
//        List<Animal> animals = new ArrayList<>();
//        List<Food> foods = new ArrayList<>();
//        while (!input.equals("End")) {
//            String[] lines = input.split("\\s+");
//
//            if (counter % 2 == 0) {
//                String animalType = lines[0];
//                String animalName = lines[1];
//                double animalWeight = Double.parseDouble(lines[2]);
//                String animalLivingRegion = lines[3];
//
//                if (animalType.equals("Cat")) {
//                    String breed = lines[4];
//                    animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, breed);
//                } else if (animalType.equals("Tiger")) {
//                    animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
//                } else if (animalType.equals("Zebra")) {
//                    animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
//                } else if (animalType.equals("Mouse")) {
//                    animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
//                }
//                animals.add(animal);
//            } else {
//                String foodType = lines[0];
//                int foodQuantity = Integer.parseInt(lines[1]);
//                Food food = null;
//                if (foodType.equals("Meat")) {
//                    food = new Meat(foodQuantity);
//                } else if (foodType.equals("Vegetable")) {
//                    food = new Vegetable(foodQuantity);
//                }
//
//                animals.get(animals.size() - 1).makeSound();
//                animal.eat(food);
//            }
//
//
//            input = bufferedReader.readLine();
//            counter++;
//        }
//        animals.forEach(System.out::println);
//    }
//}