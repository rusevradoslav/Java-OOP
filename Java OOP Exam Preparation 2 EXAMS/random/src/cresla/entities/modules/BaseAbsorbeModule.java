package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorbeModule extends Modules implements AbsorbingModule {
    private int heatAbsorbing;

    protected BaseAbsorbeModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(String.format(" Module - %d", this.getId())).append(System.lineSeparator())
                .append(String.format("Heat Absorbing: %d", this.getHeatAbsorbing())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}

