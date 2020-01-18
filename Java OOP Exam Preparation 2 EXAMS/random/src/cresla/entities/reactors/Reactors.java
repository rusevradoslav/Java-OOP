package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Reactor;



public abstract class Reactors implements Reactor {
    private int id;
    private ModuleContainer moduleContainer;

    protected Reactors(int id, int capacity) {
        this.id = id;
        this.moduleContainer = new ModuleContainer(capacity);
    }

    @Override
    public long getTotalEnergyOutput() {

        return moduleContainer.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return moduleContainer.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        return this.moduleContainer.getModuleByInputCount();
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.moduleContainer.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.moduleContainer.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

}
