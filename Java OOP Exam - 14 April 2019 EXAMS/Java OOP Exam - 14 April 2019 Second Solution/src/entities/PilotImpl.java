package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.name = name;
        machines = new ArrayList<>();
    }

    @Override
    public String getName() {

        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if (machine == null) {
            throw new NullPointerException("Null machine cannot be added to the pilot.");
        }
        this.machines.add(machine);
    }

    @Override
    public List<Machine> getMachines() {
        return this.machines;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" - ").append(this.machines.size()).append(" machines").append(System.lineSeparator());
        for (Machine m : this.machines) {
            sb.append("- ").append(m.getName()).append(System.lineSeparator()).append(m.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();

    }
}
