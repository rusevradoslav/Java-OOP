package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.core.interfaces.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineImpl implements Engine {
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl(Controller controller) {
        this.controller = controller;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        String returned = "";
        while (!returned.equals("Exit")) {
            try {
                returned = execute();
                if (returned!=null || !returned.equals("Exit")) {
                    System.out.println(returned);
                }

            } catch (IOException | NullPointerException | IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private String execute() throws IOException {
        String toReturn = null;
        String line = this.reader.readLine();
        if (line.equals("Exit")) {
            return line;
        }
        String[] data = line.split("\\s+");
        String command = data[0];
        if (command.equals("AddPlayer")) {
            String name = data[1];
            toReturn = this.controller.addPlayer(name);
        } else if (command.equals("AddGun")) {
            String type = data[1];
            String name = data[2];
            toReturn = this.controller.addGun(type, name);
        } else if (command.equals("AddGunToPlayer")) {
            String name = data[1];
            toReturn = this.controller.addGunToPlayer(name);
        } else if (command.equals("Fight")) {
            toReturn = this.controller.fight();
        }

        return toReturn;
    }
}
