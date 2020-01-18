package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double INITIAL_ATTACK_POINTS_MODIFIER = 40.0;
    private static final double INITIAL_DEFENSE_POINTS_MODIFIER = 30.0;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double defensePointsModifier;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.attackPointsModifier = INITIAL_ATTACK_POINTS_MODIFIER;
        this.defensePointsModifier = INITIAL_DEFENSE_POINTS_MODIFIER;
        setDefenseMode(true);
    }

    public void setDefenseMode(boolean defenseMode) {
        this.defenseMode = defenseMode;
        if(this.defenseMode) {
            setAttackPoints(getAttackPoints() - this.attackPointsModifier);
            setDefensePoints(getDefensePoints() + this.defensePointsModifier);
        }
        else {
            setAttackPoints(getAttackPoints() + this.attackPointsModifier);
            setDefensePoints(getDefensePoints() - this.defensePointsModifier);
        }
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        setDefenseMode(!this.defenseMode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("- %s", getName())).append(System.lineSeparator());
        sb.append(" *Type: Tank").append(System.lineSeparator());
        sb.append(super.toString());
        String mode = "ON";
        if(!this.defenseMode) {
            mode = "OFF";
        }
        sb.append(String.format(" *Defense Mode(%s)", mode)).append(System.lineSeparator());
        return sb.toString();
    }
}