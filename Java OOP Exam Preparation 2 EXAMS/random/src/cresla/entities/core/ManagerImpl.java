package cresla.entities.core;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.*;
import cresla.interfaces.Module;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {
    private List<Reactor> reactors;
    private List<cresla.interfaces.Module> modules;
    private int id;
    private int cryoReactors;
    private int heatReactors;
    private int energyModules;
    private int absorbingModules;

    public ManagerImpl() {
        this.reactors = new ArrayList<>();
        this.modules = new ArrayList<>();
        this.id = 1;
        this.cryoReactors = 0;
        this.heatReactors = 0;
        this.energyModules = 0;
        this.absorbingModules = 0;
    }

    public int getId() {
        return this.id++;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String type = arguments.get(0);
        int additionalParam = Integer.parseInt(arguments.get(1));
        int capacity = Integer.parseInt(arguments.get(2));
        String ouput = "";
        switch (type) {
            case "Cryo":
                Reactor reactor = new CryoReactor(this.getId(), additionalParam, capacity);
                reactors.add(reactor);
                ouput = String.format("Created %s Reactor - %d", type, reactor.getId());
                cryoReactors++;
                break;
            case "Heat":
                Reactor reactor1 = new HeatReactor(this.getId(), additionalParam, capacity);
                reactors.add(reactor1);
                ouput = String.format("Created %s Reactor - %d", type, reactor1.getId());
                heatReactors++;
                break;
        }
        return ouput;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorId = Integer.parseInt(arguments.get(0));
        String moduleType = arguments.get(1);
        int additionalParam = Integer.parseInt(arguments.get(2));
        String output = "";
        if (this.reactors.stream().anyMatch(r -> r.getId() == reactorId)) {
            Reactor reactor = this.reactors.stream().filter(r -> r.getId() == reactorId).limit(1).collect(Collectors.toList()).get(0);
            switch (moduleType) {
                case "CryogenRod":
                    EnergyModule module = new CryogenRod(this.getId(), additionalParam);
                    reactor.addEnergyModule(module);
                    this.modules.add(module);
                    output = String.format("Added %s - %d toReactor - %d", moduleType, module.getId(), reactorId);
                    energyModules++;
                    break;
                case "HeatProcessor":
                    AbsorbingModule module1 = new HeatProcessor(this.getId(), additionalParam);
                    reactor.addAbsorbingModule(module1);
                    this.modules.add(module1);
                    output = String.format("Added %s - %d toReactor - %d", moduleType, module1.getId(), reactorId);
                    absorbingModules++;
                    break;
                case "CooldownSystem":
                    AbsorbingModule module2 = new CooldownSystem(this.getId(), additionalParam);
                    reactor.addAbsorbingModule(module2);
                    this.modules.add(module2);
                    output = String.format("Added %s - %d toReactor - %d", moduleType, module2.getId(), reactorId);
                    absorbingModules++;
                    break;
            }
        }
        return output;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int currId = Integer.parseInt(arguments.get(0));
        String output = "";
        for (Reactor reactor : reactors) {
            if (reactor.getId() == currId) {
                output = reactor.toString();
            }
        }

        for (Module module : modules) {
            if (module.getId() == currId) {
                output = module.toString();
            }
        }
        return output;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        long totalEnergyOutputCry = 0L;
        for (Reactor reactor1 : reactors) {
            if (reactor1.getClass().getSimpleName().equals("CryoReactor")) {
                long totalEnergyOutput = reactor1.getTotalEnergyOutput();
                totalEnergyOutputCry += totalEnergyOutput;
            }
        }
        long totalHeatAbsorbingCry = reactors.stream().filter(reactor -> reactor.getClass().getSimpleName().equals("CryoReactor")).mapToLong(Reactor::getTotalHeatAbsorbing).sum();
        long totalEnergyOutputHeat = reactors.stream().filter(reactor -> reactor.getClass().getSimpleName().equals("HeatReactor")).mapToLong(Reactor::getTotalEnergyOutput).sum();
        long totalHeatAbsorbingHeat = reactors.stream().filter(reactor -> reactor.getClass().getSimpleName().equals("HeatReactor")).mapToLong(Reactor::getTotalHeatAbsorbing).sum();

        long totalEnergy = totalEnergyOutputCry + totalEnergyOutputHeat;
        long totalAbsorbing = totalHeatAbsorbingCry + totalHeatAbsorbingHeat;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Cryo Reactors: %d", this.cryoReactors)).append(System.lineSeparator())
                .append(String.format("Heat Reactors: %d", this.heatReactors)).append(System.lineSeparator())
                .append(String.format("Energy Modules: %d", this.energyModules)).append(System.lineSeparator())
                .append(String.format("Absorbing Modules: %d", this.absorbingModules)).append(System.lineSeparator())
                .append(String.format("Total Energy Output: %d", totalEnergy)).append(System.lineSeparator())
                .append(String.format("Total Heat Absorbing: %d", totalAbsorbing)).append(System.lineSeparator());

        return sb.toString().trim();
    }
}
