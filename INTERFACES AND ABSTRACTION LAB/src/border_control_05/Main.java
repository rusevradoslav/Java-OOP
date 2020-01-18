package border_control_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Identifiable> robots = new ArrayList<>();
        List<Identifiable> citizens = new ArrayList<>();

        String input = reader.readLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[0], tokens[1]);
                robots.add(robot);
            } else {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                citizens.add(citizen);
            }
            input = reader.readLine();
        }

        String lastNumberId = reader.readLine();


        robots.stream().filter(e -> e.getId().endsWith(lastNumberId)).forEach(robot -> System.out.println(robot.getId()));
        citizens.stream().filter(e -> e.getId().endsWith(lastNumberId)).forEach(citizen -> System.out.println(citizen.getId()));
    }
}



