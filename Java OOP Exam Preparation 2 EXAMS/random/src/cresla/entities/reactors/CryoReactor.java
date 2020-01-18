package cresla.entities.reactors;

public class CryoReactor extends Reactors {
    private int cryoProductionIndex;

    public CryoReactor(int id, int cryoProductionIndex, int capacity) {
        super(id, capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput() * cryoProductionIndex;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" - ").append(this.getId()).append(System.lineSeparator())
                .append(String.format("Energy Output: %d", this.getTotalEnergyOutput())).append(System.lineSeparator())
                .append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing())).append(System.lineSeparator())
                .append(String.format("Modules: %d", this.getModuleCount())).append(System.lineSeparator());
        return sb.toString().trim();
    }
}
