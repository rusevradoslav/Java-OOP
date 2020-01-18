package military_elite_04.military.entities;

import military_elite_04.military.enumerations.Corp;
import military_elite_04.military.interfaces.Engineer;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Set<Repair> repairs;

    public EngineerImpl(int id, String name, String lastName, double salary, Corp corps) {
        super(id, name, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append("Repairs:");
        sb.append(System.lineSeparator());
        for (Repair repair : repairs) {
            sb.append(repair.toString()).append(System.lineSeparator());


        }
        return sb.toString().trim();
    }
}
