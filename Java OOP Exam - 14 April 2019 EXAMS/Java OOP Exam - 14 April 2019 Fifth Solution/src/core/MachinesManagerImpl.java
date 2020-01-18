package core;

import common.OutputMessages;
import core.interfaces.MachineFactory;
import core.interfaces.MachinesManager;
import core.interfaces.PilotFactory;
import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.Map;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory,
                               MachineFactory machineFactory,
                               Map<String, Pilot> pilots,
                               Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {
        Pilot pilot = this.pilotFactory.createPilot(name);
        if (this.pilots.containsKey(name)) {
            return String.format(OutputMessages.pilotExists, name);
        }
        this.pilots.put(name, pilot);
        return String.format(OutputMessages.pilotHired, name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }
        this.machines.put(name, this.machineFactory.createTank(name, attackPoints, defensePoints));
        return String.format(OutputMessages.tankManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            return String.format(OutputMessages.machineExists, name);
        }
        this.machines.put(name, this.machineFactory.createFighter(name, attackPoints, defensePoints));
        return String.format(OutputMessages.fighterManufactured, name, attackPoints, defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Pilot pilot = this.pilots.get(selectedPilotName);
        Machine machine = this.machines.get(selectedMachineName);
        if (pilot == null) {
            return String.format(OutputMessages.pilotNotFound, selectedPilotName);
        } else if (machine == null) {
            return String.format(OutputMessages.machineNotFound, selectedMachineName);
        } else if (machine.getPilot() != null) {
            return String.format(OutputMessages.machineHasPilotAlready, selectedMachineName);
        }

        machine.setPilot(pilot);
        pilot.addMachine(machine);

        return String.format(OutputMessages.machineEngaged, selectedPilotName, selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attackingMachine = this.machines.get(attackingMachineName);
        Machine defendingMachine = this.machines.get(defendingMachineName);

        if (attackingMachine == null) {
            return String.format(OutputMessages.machineNotFound, attackingMachineName);
        }
        if (defendingMachine == null) {
            return String.format(OutputMessages.machineNotFound, defendingMachineName);
        }

        double attackPointsAttacker = attackingMachine.getAttackPoints();
        double defendPointsDefender = defendingMachine.getDefensePoints();
        double defenderHealth = defendingMachine.getHealthPoints();

        attackingMachine.attack(defendingMachine.getName());

        if (attackPointsAttacker > defendPointsDefender) {
            defendingMachine.setHealthPoints(defenderHealth - attackPointsAttacker);
        }

        return String.format(OutputMessages.attackSuccessful,
                defendingMachineName, attackingMachineName, defendingMachine.getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = this.pilots.get(pilotName);
        if (pilot == null) {
            return String.format("Pilot %s could not be found", pilotName);
        }
        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Machine fighter = this.machines.get(fighterName);
        if (fighter instanceof Fighter) {
            ((Fighter) fighter).toggleAggressiveMode();
            return String.format(OutputMessages.fighterOperationSuccessful, fighterName);
        } else {
            return String.format(OutputMessages.notSupportedOperation, fighterName);
        }
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Machine tank = this.machines.get(tankName);
        if (tank instanceof Tank) {
            ((Tank) tank).toggleDefenseMode();
            return String.format(OutputMessages.tankOperationSuccessful, tankName);
        } else {
            return String.format(OutputMessages.notSupportedOperation, tankName);
        }
    }
}
