package spaceStation.core;

import spaceStation.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals(Command.Exit.name())) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }

    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddAstronaut:
                result = addAstronaut(data);
                break;
            case AddPlanet:
                result = addPlanet(data);
                break;
            case RetireAstronaut:
                result = retireAstronaut(data);
                break;
            case ExplorePlanet:
                result = explorePlanet(data);
                break;
            case Report:
                result = report();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }

        return result;
    }

    private String retireAstronaut(String[] data) {
        String astronautName = data[0];
        return this.controller.retireAstronaut(astronautName);
    }

    private String report() {
        return this.controller.report();
    }

    private String explorePlanet(String[] data) {
        String planetName = data[0];
        return this.controller.explorePlanet(planetName);
    }

    private String addPlanet(String[] data) {
        String planetName = data[0];
        String[] items = Arrays.stream(data).skip(1).toArray(String[]::new);
        return this.controller.addPlanet(planetName, items);
    }

    private String addAstronaut(String[] data) {
        String type = data[0];
        String astronautName = data[1];
        return this.controller.addAstronaut(type, astronautName);
    }
}