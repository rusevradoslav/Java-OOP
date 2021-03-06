package cresla.entities.modules;

public class CooldownSystem extends AbsorbingModuleImpl {
    private static final String MODULE_TYPE = "CoolingSystem";
    private static final String PARAMETER_TYPE = "Heat Absorbing";

    public CooldownSystem(int id, int property) {
        super(id, property);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(MODULE_TYPE).append(super.toString());
        result.append(System.lineSeparator());
        result.append(String.format("%s: %d", PARAMETER_TYPE, this.getHeatAbsorbing()));

        return result.toString();
    }
}
