package military_elite_04.military.entities;

import military_elite_04.military.enumerations.Corp;
import military_elite_04.military.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corp corps;

    protected SpecialisedSoldierImpl(int id, String name, String lastName, double salary, Corp corps) {
        super(id, name, lastName, salary);
        this.corps = corps;
    }


    @Override
    public String getCorps() {
        return this.corps.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format("Corps: %s", this.getCorps()));
        return sb.toString().trim();
    }
}