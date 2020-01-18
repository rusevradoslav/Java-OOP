package cresla.entities.reactors;

public class CryoReactor extends ReactorImpl {
    private int cryoProductionIndex;
    private static final String REACTOR_TYPE = "CryoReactor";

    public CryoReactor(int id, int capacity, int cryoProductionIndex) {
        super(id, capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getTotalEnergyOutput() * cryoProductionIndex;
        if (result > getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(REACTOR_TYPE).append(super.toString());
        return result.toString();
    }
}
