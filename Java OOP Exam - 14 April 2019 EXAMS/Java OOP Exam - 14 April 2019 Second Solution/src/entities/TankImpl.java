package entities;

import entities.BaseMachine;
import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_POINTS_MODIFIER = 40.0;
    private static final double DEFENCE_POINTS_MODIFIER = 30.0;
    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setDefenseMode(true);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    public void setDefenseMode(boolean defenseMode) {
        this.defenseMode = defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (getDefenseMode()) {
            setDefenseMode(false);
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_MODIFIER);
        } else {
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_MODIFIER);
            setDefenseMode(true);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append(" *Type: Tank").append(System.lineSeparator()).append(super.toString())
                .append(System.lineSeparator()).append(" *Defense Mode(");
        if(this.defenseMode){
            sb.append("ON)");
        }else {
            sb.append("OF)");
        }
        return sb.toString().trim();
    }
}
