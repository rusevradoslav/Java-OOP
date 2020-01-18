package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.PilotImpl;
import entities.TankImpl;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.LinkedHashMap;
import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;


    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        Pilot pilot = new PilotImpl(name);
        if (pilots.containsKey(pilot.getName())) {
            return String.format(pilotExists, pilot.getName());
        } else {
            pilots.put(pilot.getName(), pilot);
            return String.format(pilotHired, pilot.getName());
        }
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        Tank tank = new TankImpl(name, attackPoints, defensePoints);
        if (machines.containsKey(tank.getName())) {
            return String.format(machineExists, tank.getName());
        } else {
            machines.put(tank.getName(), tank);
            return String.format(tankManufactured, tank.getName(), tank.getAttackPoints(), tank.getDefensePoints());
        }
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        Fighter fighter = new FighterImpl(name, attackPoints, defensePoints);
        if (machines.containsKey(fighter.getName())) {
            return String.format(machineExists, fighter.getName());
        } else {
            machines.put(fighter.getName(), fighter);
            return String.format(fighterManufactured, fighter.getName(), fighter.getAttackPoints(), fighter.getDefensePoints());
        }
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if (!pilots.containsKey(selectedPilotName)) {
            return String.format(pilotNotFound, selectedPilotName);
        }
        if (!machines.containsKey(selectedMachineName)) {
            return String.format(machineNotFound, selectedMachineName);
        }

        Pilot pilot = pilots.get(selectedPilotName);
        Machine machine = machines.get(selectedMachineName);
        if (pilot.getMachines().contains(machine)) {
            return String.format(machineHasPilotAlready, machine.getName());
        }
        pilot.addMachine(machine);
        machine.setPilot(pilot);
        return String.format(machineEngaged, pilot.getName(), machine.getName());
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attackMachine = machines.get(attackingMachineName);
        Machine defendMachine = machines.get(defendingMachineName);

        if (!machines.containsKey(attackingMachineName)) {
            String.format(machineNotFound, attackingMachineName);
        }
        if (!machines.containsKey(defendingMachineName)) {
            String.format(machineNotFound, defendingMachineName);
        }
        double currentAttackPoint = attackMachine.getAttackPoints();
        double currentDefendPoint = defendMachine.getDefensePoints();

        if (currentAttackPoint > currentDefendPoint) {
            defendMachine.setHealthPoints(defendMachine.getHealthPoints() - currentAttackPoint);
            if (defendMachine.getHealthPoints() < 0) {
                defendMachine.setHealthPoints(0);
            }
        }
        attackMachine.attack(defendMachine.getName());

        return String.format(attackSuccessful, defendMachine.getName(), attackMachine.getName(), defendMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if (!pilots.containsKey(pilotName)) {
            return String.format(pilotNotFound, pilotName);
        }
        return pilots.get(pilotName).report();
    }


    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if (!machines.containsKey(fighterName)) {
            return String.format(machineNotFound, fighterName);
        }
        Fighter fighter = (Fighter) machines.get(fighterName);

        if (fighter.getClass().getSimpleName().equals("TankImpl")) {
            return String.format(notSupportedOperation, fighterName);
        }
        fighter.toggleAggressiveMode();
        return String.format(fighterOperationSuccessful, fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if (!machines.containsKey(tankName)) {
            return String.format(machineNotFound, tankName);
        }
        Tank tank = (Tank) this.machines.get(tankName);

        if (tank.getClass().getSimpleName().equals("FighterImpl")) {
            return String.format(notSupportedOperation, tankName);
        }
        tank.toggleDefenseMode();
        return String.format(tankOperationSuccessful, tankName);
    }
}