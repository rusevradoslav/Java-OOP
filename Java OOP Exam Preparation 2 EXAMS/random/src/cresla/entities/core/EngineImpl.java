package cresla.entities.core;

import cresla.interfaces.Manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EngineImpl implements Engine, Runnable {
    Manager manager;
    Scanner scanner;

    public EngineImpl(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        String result = null;
        while (true) {
            try {
                result = processInput();
                if ("Exit".equals(result)) {
                    break;
                }
            } catch (IllegalArgumentException | NullPointerException e) {
                result = e.getMessage();
            }
            System.out.println(result);
        }
    }

    private String processInput() {
        String[] tokens = this.scanner.nextLine().split("\\s+");
        String command = tokens[0];
        List<String> arguments = Arrays.stream(tokens).skip(1).collect(Collectors.toCollection(ArrayList::new));
        String result = "";
        switch (command) {
            case "Reactor":
                result = manager.reactorCommand(arguments);
                break;
            case "Module":
                result = manager.moduleCommand(arguments);
                break;
            case "Report":
                result = manager.reportCommand(arguments);
                break;
            case "Exit":
                result = manager.exitCommand(arguments);
                break;
        }
        return result.trim();
    }
}
