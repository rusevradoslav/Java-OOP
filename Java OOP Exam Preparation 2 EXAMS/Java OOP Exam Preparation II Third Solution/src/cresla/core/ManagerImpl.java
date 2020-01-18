package cresla.core;

import cresla.entities.modules.CooldownSystem;
import cresla.entities.modules.CryogenRod;
import cresla.entities.modules.HeatProcessor;
import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Module;
import cresla.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerImpl implements Manager {

    private List<Reactor> reactors;
    private List<Module> modules;
    private static int idCounter;

    public ManagerImpl() {
        this.reactors = new ArrayList<>();
        this.modules = new ArrayList<>();
        idCounter = 1;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String result = null;
        String type = arguments.get(0);
        int parameter = Integer.parseInt(arguments.get(1));
        int capacity = Integer.parseInt(arguments.get(2));
        if (type.equals("Cryo")) {
            this.reactors.add(new CryoReactor(this.idCounter, parameter, capacity));
            result = String.format("Created %s Reactor - %d", type, this.idCounter);
            this.idCounter++;
        } else if (type.equals("Heat")) {
            this.reactors.add(new HeatReactor(this.idCounter, parameter, capacity));
            result = String.format("Created %s Reactor - %d", type, this.idCounter);
            this.idCounter++;
        }
        return result;
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        String result = null;
        int reactorId = Integer.parseInt(arguments.get(0));
        String type = arguments.get(1);
        int parameter = Integer.parseInt(arguments.get(2));
        if (this.reactors.stream().anyMatch(r -> r.getId() == reactorId)) {
            Reactor current = this.reactors.stream().filter(r -> r.getId() == reactorId).limit(1).collect(Collectors.toList()).get(0);
            if (type.equals(CryogenRod.class.getSimpleName())) {
                EnergyModule modul = new CryogenRod(this.idCounter, parameter);
                current.addEnergyModule(modul);
                this.modules.add(modul);
            } else if (type.equals(HeatProcessor.class.getSimpleName())) {
                AbsorbingModule modul = new HeatProcessor(this.idCounter, parameter);
                current.addAbsorbingModule(modul);
                this.modules.add(modul);
            } else if (type.equals(CooldownSystem.class.getSimpleName())) {
                AbsorbingModule modul = new CooldownSystem(this.idCounter, parameter);
                current.addAbsorbingModule(modul);
                this.modules.add(modul);
            }
            result = String.format("Added %s - %d to Reactor - %d", type, this.idCounter, current.getId());
            this.idCounter++;
        }

        return result;
    }

    @Override
    public String reportCommand(List<String> arguments) {
        int id = Integer.parseInt(arguments.get(0));
        for (Reactor r : this.reactors) {
            if (r.getId() == id) {
                return r.toString();
            }
        }
        for (Module m : this.modules) {
            if (m.getId() == id) {
                return m.toString();
            }
        }
        return null;
    }

    @Override
    public String exitCommand(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        long energyReactorCount = this.reactors.stream().filter(r -> r.getClass().getSimpleName().equals("CryoReactor")).count();
        long absorberReactorCount = this.reactors.stream().filter(r -> r.getClass().getSimpleName().equals("HeatReactor")).count();
        long energyOutput = 0;
        long absorbedEnergy  = 0;
        for (Reactor r: this.reactors) {
            if(r.getClass().getSimpleName().equals("CryoReactor")){
                CryoReactor reactor = (CryoReactor) r;
                energyOutput+=reactor.getTotalEnergyOutput();
                absorbedEnergy +=r.getTotalHeatAbsorbing();
            }else{
                HeatReactor reactor = (HeatReactor)r;
                energyOutput+=r.getTotalEnergyOutput();
                absorbedEnergy+=reactor.getTotalHeatAbsorbing();
            }
        }
        long energyModulesCount = this.modules.stream().filter(m -> m.getClass().getSimpleName().equals("CryogenRod")).count();
        long absorberModulesCount = this.modules.size() - energyModulesCount;
        sb.append("Cryo Reactors: ").append(energyReactorCount).append(System.lineSeparator())
                .append("Heat Reactors: ").append(absorberReactorCount).append(System.lineSeparator())
                .append("Energy Modules: ").append(energyModulesCount).append(System.lineSeparator())
                .append("Absorbing Modules: ").append(absorberModulesCount).append(System.lineSeparator())
                .append("Total Energy Output: ").append(energyOutput).append(System.lineSeparator())
                .append("Total Heat Absorbing: ").append(absorbedEnergy);
        return sb.toString().trim();
    }
}
