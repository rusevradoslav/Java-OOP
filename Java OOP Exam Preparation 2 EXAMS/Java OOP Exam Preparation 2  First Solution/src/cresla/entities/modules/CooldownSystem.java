package cresla.entities.modules;

public class CooldownSystem extends AbsorberModuleImpl {
    private static final String MODULE_TYPE = "CoolingSystem";
    private static final String PARAMETER_TYPE = "Heat Absorbing";

    public CooldownSystem(int id, int heatAbsorbing) {
        super(id, heatAbsorbing);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MODULE_TYPE)
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s: %d", PARAMETER_TYPE, super.getHeatAbsorbing()));
        return sb.toString().trim();
    }
}
