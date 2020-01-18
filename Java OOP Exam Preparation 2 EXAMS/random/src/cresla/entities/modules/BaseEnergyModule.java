package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends Modules implements EnergyModule {
    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(String.format(" Module - %d", this.getId())).append(System.lineSeparator())
                .append(String.format("Energy Output: %d", this.getEnergyOutput())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}

