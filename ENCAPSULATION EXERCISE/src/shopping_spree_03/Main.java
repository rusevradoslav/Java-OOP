package shopping_spree_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(";");
        List<Person> persons = new LinkedList<>();
        Arrays.stream(data).forEach(p -> {
            String[] tokens = p.split("=");
            try {
                persons.add(new Person(tokens[0], Double.parseDouble(tokens[1])));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        String[] input = scanner.nextLine().split(";");

        List<Product> products = new LinkedList<>();
        Arrays.stream(input).forEach(p -> {
            String[] tokens = p.split("=");
            try {
                products.add(new Product(tokens[0], Double.parseDouble(tokens[1])));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });


        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            for (Person person : persons) {
                if (person.getName().equals(tokens[0])) {
                    Product product = null;
                    for (Product p : products) {
                        if (p.getName().equals(tokens[1])) {
                            product = p;
                            break;
                        }
                    }
                    if (product != null) {
                        try {
                            person.buyProduct(product);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                }
            }
            line = scanner.nextLine();
        }
        for (Person person : persons) {
            System.out.println(person.getName() + " bought " + person.getProducts());
        }

    }

}
