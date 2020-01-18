package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.core.interfaces.Engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EngineImpl implements Runnable, Engine {
    private ChampionshipController controller;
    private Scanner scanner;

    public EngineImpl(ChampionshipController controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public void run() {
        String result = null;
        while (true) {
            try {
                result = processInput();
                if ("End".equals(result)) {
                    break;
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }

    private String processInput() {
        String[] input = this.scanner.nextLine().split("\\s+");
        String command = input[0];
        String[] tokens = Arrays.stream(input).skip(1).toArray(String[]::new);
        String result = "";
        switch (command) {
            case "CreateRider":
                result = controller.createRider(tokens[0]);
                break;
            case "CreateMotorcycle":
                result = controller.createMotorcycle(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                break;
            case "AddMotorcycleToRider":
                result = controller.addMotorcycleToRider(tokens[0], tokens[1]);
                break;
            case "AddRiderToRace":
                result = controller.addRiderToRace(tokens[0],tokens[1]);
                break;
            case "CreateRace":
                result = controller.createRace(tokens[0],Integer.parseInt(tokens[1]));
                break;
            case "StartRace":
                result = controller.startRace(tokens[0]);
                break;
        }

        return result.trim();
    }
}

