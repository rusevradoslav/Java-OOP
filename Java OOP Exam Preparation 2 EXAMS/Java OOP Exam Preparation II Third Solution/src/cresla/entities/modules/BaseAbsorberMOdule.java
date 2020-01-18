package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorberMOdule extends BaseModule implements AbsorbingModule {
    private int heatAbsorbing;

    protected BaseAbsorberMOdule(int id, int heatAbsorbing) {
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
        sb.append(this.getClass().getSimpleName()).append(" Module – ").append(this.getId()).append(System.lineSeparator())
                .append("heatAbsorbing: ").append(this.heatAbsorbing);
        return sb.toString().trim();
    }
}
