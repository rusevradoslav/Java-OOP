package military_elite_04.military.entities;

public class Repair {
    private String partName;
    private int hoursWorked;

    public Repair(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(String.format("Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked));
        return sb.toString();
    }
}
