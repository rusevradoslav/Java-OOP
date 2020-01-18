package cresla.entities.modules;

public class CryogenRod extends EnergyModuleImpl {
    private static final String MODULE_TYPE = "CryogenRod";
    private static final String PARAMETER_TYPE = "Energy Output";

    public CryogenRod(int id, int energyOutput) {
        super(id, energyOutput);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MODULE_TYPE)
                .append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("%s: %d", PARAMETER_TYPE, super.getEnergyOutput()));
        return sb.toString().trim();
    }
}


