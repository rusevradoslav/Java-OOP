package animal_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!line.equals("Beast!")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            try {


                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];

                switch (line) {
                    case "Dog":
                        Dog dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                    case "Kittens":
                        Kitten kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "TomCat":
                        Tomcat tomCat = new Tomcat(name, age);
                        animals.add(tomCat);
                        break;

                }
            } catch (IllegalArgumentException e) {

            }
            line = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal.toString().trim());
        }

    }
}
