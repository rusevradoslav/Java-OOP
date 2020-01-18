import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("Over")) {
            String[] commandLine = input.split("\\s+");
            String commandName = commandLine[0];
            try {
                switch (commandName) {
                    case "Hire":
                        processHirePilot(machinesManager, commandLine);
                        break;
                    case "Report":
                        processReportPilot(machinesManager, commandLine);
                        break;
                    case "ManufactureTank":
                        processManufactureTank(machinesManager, commandLine);
                        break;
                    case "ManufactureFighter":
                        processManufactureFighter(machinesManager, commandLine);
                        break;
                    case "Engage":
                        processEngage(machinesManager, commandLine);
                        break;
                    case "Attack":
                        processAttack(machinesManager, commandLine);
                        break;
                    case "DefenseMode":
                        processDefenseMode(machinesManager, commandLine);
                        break;
                    case "AggressiveMode":
                        processAggressiveMode(machinesManager, commandLine);
                        break;
                    default:
                        break;
                }
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private static void processHirePilot(MachinesManager machinesManager, String[] commandLine) {
        String pilotName = commandLine[1];
        System.out.println(machinesManager.hirePilot(pilotName));

    }

    private static void processReportPilot(MachinesManager machinesManager, String[] commandLine) {
        String pilotName = commandLine[1];
        System.out.println(machinesManager.pilotReport(pilotName));
    }

    private static void processManufactureTank(MachinesManager machinesManager, String[] commandLine) {
        String tankName = commandLine[1];
        double attackPoints = Double.parseDouble(commandLine[2]);
        double defensePoints = Double.parseDouble(commandLine[3]);
        System.out.println(machinesManager.manufactureTank(tankName, attackPoints, defensePoints));
    }

    private static void processManufactureFighter(MachinesManager machinesManager, String[] commandLine) {
        String fighterName = commandLine[1];
        double attackPoints = Double.parseDouble(commandLine[2]);
        double defensePoints = Double.parseDouble(commandLine[3]);
        System.out.println(machinesManager.manufactureFighter(fighterName, attackPoints, defensePoints));
    }

    private static void processEngage(MachinesManager machinesManager, String[] commandLine) {
        String pilotName = commandLine[1];
        String machineName = commandLine[2];
        System.out.println(machinesManager.engageMachine(pilotName, machineName));
    }

    private static void processAttack(MachinesManager machinesManager, String[] commandLine) {
        String attackingMachineName = commandLine[1];
        String defendingMachineName = commandLine[2];
        System.out.println(machinesManager.attackMachines(attackingMachineName, defendingMachineName));
    }

    private static void processDefenseMode(MachinesManager machinesManager, String[] commandLine) {
        String machineName = commandLine[1];
        System.out.println(machinesManager.toggleTankDefenseMode(machineName));
    }

    private static void processAggressiveMode(MachinesManager machinesManager, String[] commandLine) {
        String machineName = commandLine[1];
        System.out.println(machinesManager.toggleFighterAggressiveMode(machineName));
    }

}

