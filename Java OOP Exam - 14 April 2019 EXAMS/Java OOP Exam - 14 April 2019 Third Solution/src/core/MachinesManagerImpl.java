package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.FighterImpl;
import entities.interfaces.*;

import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String,Pilot> pilots;
    private Map<String,Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
     this.pilotFactory = pilotFactory;
     this.machineFactory = machineFactory;
     this.pilots = pilots;
     this.machines = machines;
    }


    @Override
    public String hirePilot(String name) {
        if(this.pilots.containsKey(name)){
            throw new IllegalArgumentException(String.format(pilotExists,name));
        }
        Pilot pilot = pilotFactory.createPilot(name);
        this.pilots.put(name, pilot);
        return String.format(pilotHired,name);
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            throw new IllegalArgumentException(String.format(machineExists,name));
        }
        Tank tank = machineFactory.createTank(name,attackPoints,defensePoints);
        this.machines.put(name,tank);
        return String.format(tankManufactured,name,attackPoints,defensePoints);
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if(this.machines.containsKey(name)){
            throw new IllegalArgumentException(String.format(machineExists,name));
        }
        Fighter fighter = new FighterImpl(name,attackPoints,defensePoints);
        this.machines.put(name,fighter);
        return String.format(fighterManufactured,name,attackPoints,defensePoints);
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        if(!this.machines.containsKey(selectedMachineName)){
            throw new IllegalArgumentException(String.format(machineNotFound,selectedMachineName));
        }
        if(!this.pilots.containsKey(selectedPilotName)){
            throw new IllegalArgumentException(String.format(pilotNotFound,selectedPilotName));
        }
        if(this.machines.get(selectedMachineName).getPilot()!=null){
            throw new IllegalArgumentException(String.format(machineHasPilotAlready,selectedMachineName));
        }
        this.pilots.get(selectedPilotName).addMachine(this.machines.get(selectedMachineName));
        this.machines.get(selectedMachineName).setPilot(this.pilots.get(selectedPilotName));
        return String.format(machineEngaged,selectedPilotName,selectedMachineName);
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        if(!this.machines.containsKey(attackingMachineName)){
            throw new IllegalArgumentException(String.format(machineNotFound,attackingMachineName));
        }
        if(!this.machines.containsKey(defendingMachineName)){
            throw new IllegalArgumentException(String.format(machineNotFound,defendingMachineName));
        }
        this.machines.get(attackingMachineName).attack(defendingMachineName);
        this.machines.get(defendingMachineName).setHealthPoints(this.machines.get(defendingMachineName).getHealthPoints()-this.machines.get(attackingMachineName).getAttackPoints());
        return String.format(attackSuccessful,defendingMachineName,attackingMachineName,this.machines.get(defendingMachineName).getHealthPoints());
    }

    @Override
    public String pilotReport(String pilotName) {
        if(!this.pilots.containsKey(pilotName)){
            throw new IllegalArgumentException(String.format(pilotNotFound,pilotName));
        }
        return this.pilots.get(pilotName).report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        if(!this.machines.containsKey(fighterName)){
              throw new IllegalArgumentException(String.format(machineNotFound,fighterName));
        }
        if(this.machines.get(fighterName).getClass().getSimpleName().equals("TankImpl")){
            throw new IllegalArgumentException(String.format(notSupportedOperation,fighterName));
        }
        Fighter fighter = (Fighter) this.machines.get(fighterName);
        fighter.toggleAggressiveMode();
        return String.format(fighterOperationSuccessful,fighterName);
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        if(!this.machines.containsKey(tankName)){
            throw new IllegalArgumentException(String.format(machineNotFound,tankName));
        }
        if(this.machines.get(tankName).getClass().getSimpleName().equals("FighterImpl")){
            throw new IllegalArgumentException(String.format(notSupportedOperation,tankName));
        }
        Tank tank = (Tank) this.machines.get(tankName);
        tank.toggleDefenseMode();
        return String.format(tankOperationSuccessful,tankName);
    }
}
