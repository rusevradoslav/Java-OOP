package cresla.entities.reactors;

public class HeatReactor extends ReactorImpl {
    private int heatReductionIndex;
    private static final String REACTOR_TYPE = "HeatReactor";

    public HeatReactor(int id, int capacity, int heatReductionIndex) {
        super(id, capacity);

        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getTotalHeatAbsorbing() + heatReductionIndex;

    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getTotalEnergyOutput();
        if (result > super.getTotalHeatAbsorbing()) {
            result = 0;
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(REACTOR_TYPE).append(super.toString());
        return sb.toString().trim();
    }
}
