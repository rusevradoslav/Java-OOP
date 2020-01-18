package food_shortage_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> buyers = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens.length == 4) {

                buyers.add(new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]));
            } else {
                buyers.add(new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]));
            }
        }

        int sum = 0;
        String line = scanner.nextLine();

        while (!line.equals("End")) {
            for (Person buyer : buyers) {
                if (buyer.getName().equals(line)) {
                   buyer.buyFood();
                }
            }

            line = scanner.nextLine();
        }
        for (Person buyer : buyers) {
            sum+=buyer.getFood();
        }
        System.out.println(sum);

    }
}
