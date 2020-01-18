package entities;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.ArrayList;
import java.util.List;

import static common.OutputMessages.*;

public abstract class BaseMachine implements Machine, Tank, Fighter, Comparable<Machine> {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;

    protected BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
       this.setName(name);
       this.setAttackPoints(attackPoints);
       this.setDefensePoints(defensePoints);
       this.setHealthPoints(healthPoints);
       this.targets = new ArrayList<>();
       pilot = null;
    }

    @Override
    public void setName(String name) {
        if(name==null || name.trim().isEmpty()){
            throw new IllegalArgumentException(NAME_IS_NULL);
        }
        this.name = name;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if(pilot == null){
            throw new NullPointerException(PILOT_IS_NULL);
        }

    }

    @Override
    public void setHealthPoints(double healthPoints) {
       this.healthPoints = healthPoints;
    }

    protected void setDefensePoints(double defensePoints){
        this.defensePoints = defensePoints;
    }

    protected void setAttackPoints(double attackPoints){
        this.attackPoints = attackPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return this.targets;
    }

    @Override
    public void attack(String target) {
        if(target==null || target.trim().isEmpty()){
            throw new IllegalArgumentException(ATTACK_TARGET_IS_NULL);
        }
        this.targets.add(target);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" *Health: ").append(this.healthPoints).append(System.lineSeparator())
                .append(" *Attack: ").append(this.attackPoints).append(System.lineSeparator())
                .append(" *Defense: ").append(this.defensePoints).append(System.lineSeparator())
                .append(" *Targets: ").append(String.join(" ",this.targets));
        return sb.toString().trim();
    }

    @Override
    public boolean getAggressiveMode() {
        return false;
    }

    @Override
    public void toggleAggressiveMode() {

    }

    @Override
    public boolean getDefenseMode() {
        return false;
    }

    @Override
    public void toggleDefenseMode() {

    }

    @Override
    public int compareTo(Machine o) {
        if(this.attackPoints>o.getAttackPoints()){
            return 1;
        }else if(this.attackPoints==o.getAttackPoints()){
            return 0;
        }else {
            return -1;
        }
    }
}
