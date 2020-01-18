import core.MachineFactoryImpl;
import core.MachinesManagerImpl;

import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;
import entities.TankImpl;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;


import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl(); //TODO change null with your implementation
        MachineFactory machineFactory = new MachineFactoryImpl(); //TODO change null with your implementation
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
         Tank tank = new TankImpl("T72",10.0,10.0);
        System.out.println(tank.getClass().getSimpleName());
    }
}
