package cresla.entities.reactors;

public class HeatReactor extends Reactors {
    private int heatReductionIndex;

    public HeatReactor(int id, int heatReductionIndex, int capacity) {
        super(id, capacity);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + heatReductionIndex;
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
