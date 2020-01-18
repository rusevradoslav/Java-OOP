package cresla.entities.reactors;

public class HeatReactor extends BaseReactor {
    private int heatReductionIndex;

    public HeatReactor(int id,int heatReductionIndex, int capacity) {
        super(id, capacity);
        this.heatReductionIndex = heatReductionIndex+this.heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + heatReductionIndex;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName()).append(" - ").append(this.getId()).append(System.lineSeparator())
                .append("Energy Output: ").append(this.getTotalEnergyOutput()).append(System.lineSeparator())
                .append("Heat Absorbing: ").append(this.getTotalHeatAbsorbing()).append(System.lineSeparator())
                .append("Modules: ").append(this.getModuleCount());
        return sb.toString().trim();
    }
}
