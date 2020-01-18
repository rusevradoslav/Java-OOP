package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class AbsorberModuleImpl extends ModuleImpl implements AbsorbingModule {
    private int heatAbsorbing;

    protected AbsorberModuleImpl(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }
}
