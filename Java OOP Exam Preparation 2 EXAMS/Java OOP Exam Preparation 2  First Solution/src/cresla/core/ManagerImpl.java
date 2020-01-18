package cresla.core;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Manager;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static cresla.common.OutputMessages.*;

public class ManagerImpl implements Manager {
    private int id;
    private Map<Integer, Reactor> reactors;
    private Map<Integer, Module> modules;
    private int cryoReactors;
    private int heatReactors;
    private int energyModules;
    private int absorbingModules;

    public ManagerImpl() {
        this.id = 1;
        this.reactors = new LinkedHashMap<>();
        this.modules = new LinkedHashMap<>();
        this.cryoReactors = 0;
        this.heatReactors = 0;
        this.energyModules = 0;
        this.absorbingModules = 0;
    }

    //type (string), additionalParameter (int), moduleCapacity (int).
    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(0);
        int additionalParameter = Integer.parseInt(arguments.get(1));
        int moduleCapacity = Integer.parseInt(arguments.get(2));
        int currentId = this.getId();
        Reactor reactor = null;
        switch (type) {
            case "Cryo":
                reactor = new CryoReactor(currentId, moduleCapacity, additionalParameter);
                cryoReactors++;
                break;
            case "Heat":
                reactor = new HeatReactor(currentId, moduleCapacity, additionalParameter);
                heatReactors++;
                break;
        }
        reactors.put(currentId, reactor);
        return String.format(REACTOR_COMMAND_OUTPUT, type, currentId);
    }

    //Parameters – reactorId (int), type (string), additionalParameter (int).
    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));

        int currentId = this.getId();
        Reactor currentReactor = this.reactors.get(reactorId);

        switch (type) {
            case "CryogenRod":
                EnergyModule rod = new CryogenRod(currentId, additionalParameter);
                this.modules.put(currentId, rod);
                currentReactor.addEnergyModule(rod);
                energyModules++;
                break;
            case "HeatProcessor":
                AbsorbingModule processor = new HeatProcessor(currentId, additionalParameter);
                this.modules.put(currentId, processor);
                currentReactor.addAbsorbingModule(processor);
                absorbingModules++;
                break;
            case "CoolingSystem":
                AbsorbingModule system = new CooldownSystem(currentId, additionalParameter);
                this.modules.put(currentId, system);
                currentReactor.addAbsorbingModule(system);
                absorbingModules++;
                break;
        }

        return String.format(MODULE_COMMAND_OUTPUT, type, currentId, reactorId);

    }

    @Override
    public String reportCommand(List<String> arguments) {
        int reportID = Integer.parseInt(arguments.get(0));

        if (this.reactors.containsKey(reportID)) {
            return this.reactors.get(reportID).toString();
        } else {
            return this.modules.get(reportID).toString();
        }
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergyOutput = this.reactors.values()
                .stream().mapToLong(Reactor::getTotalEnergyOutput).sum();

        long totalHeatAbsorbing = this.reactors.values()
                .stream().mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        return String.format(EXIT_COMMAND_OUTPUT,
                cryoReactors,
                heatReactors,
                energyModules,
                absorbingModules,
                totalEnergyOutput,
                totalHeatAbsorbing);
    }


    private int getId() {
        return this.id++;
    }
}
