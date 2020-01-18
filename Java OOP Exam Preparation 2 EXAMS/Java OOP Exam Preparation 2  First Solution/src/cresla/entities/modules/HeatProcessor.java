package cresla.entities.modules;

public class HeatProcessor extends AbsorberModuleImpl {
    private static final String MODULE_TYPE = "HeatProcessor";
    private static final String PARAMETER_TYPE = "Heat Absorbing";
    public HeatProcessor(int id, int heatAbsorbing) {
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
