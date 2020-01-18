package military_elite_04.military.entities;

import military_elite_04.military.entities.SoldierImpl;
import military_elite_04.military.interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;


    public PrivateImpl(int id, String name, String lastName, double salary) {
        super(id, name, lastName);
        if (salary > 0) {
            this.salary = salary;
        }
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(String.format(" Salary: %.2f", this.salary));
        return sb.toString().trim();
    }
}
