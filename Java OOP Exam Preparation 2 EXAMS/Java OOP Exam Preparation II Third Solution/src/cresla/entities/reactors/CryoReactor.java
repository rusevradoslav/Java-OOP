package cresla.entities.reactors;

public class CryoReactor extends BaseReactor {
    private int cryoProductionIndex;

    public CryoReactor(int id,int cryoProductionIndex, int capacity) {
        super(id, capacity);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        return super.getTotalEnergyOutput()*this.cryoProductionIndex;
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
