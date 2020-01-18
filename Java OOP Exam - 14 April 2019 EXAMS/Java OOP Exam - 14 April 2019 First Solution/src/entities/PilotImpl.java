package entities;

import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.ArrayList;
import java.util.List;

import static common.OutputMessages.MACHINE_IS_NULL;
import static common.OutputMessages.PILOT_NAME_IS_NULL;

public class PilotImpl implements Pilot {
    private String name;
    private List<Machine> machines;

    public PilotImpl(String name) {
        this.setName(name);
        this.machines = new ArrayList<>();
    }

    private void setName(String name){
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException(PILOT_NAME_IS_NULL);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addMachine(Machine machine) {
        if(machine==null){
            throw new NullPointerException(MACHINE_IS_NULL);
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
        for (Machine m: this.machines){
            sb.append("- ").append(m.getName()).append(System.lineSeparator()).append(m.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
