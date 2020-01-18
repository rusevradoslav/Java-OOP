package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double INITIAL_ATTACK_POINTS_MODIFIER = 50.0;
    private static final double INITIAL_DEFENSE_POINTS_MODIFIER = 25.0;

    private double attackPointsModifier;
    private double defensePointsModifier;

    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.attackPointsModifier = INITIAL_ATTACK_POINTS_MODIFIER;
        this.defensePointsModifier = INITIAL_DEFENSE_POINTS_MODIFIER;
        setAggressiveMode(true);
    }

    public void setAggressiveMode(boolean aggressiveMode) {
        this.aggressiveMode = aggressiveMode;
        if(this.aggressiveMode) {
            setAttackPoints(getAttackPoints() + this.attackPointsModifier);
            setDefensePoints(getDefensePoints() - this.defensePointsModifier);
        }
        else {
            setAttackPoints(getAttackPoints() - this.attackPointsModifier);
            setDefensePoints(getDefensePoints() + this.defensePointsModifier);
        }
    }

    @Override
    public boolean getAggressiveMode() {

        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        setAggressiveMode(!this.aggressiveMode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("- %s", getName())).append(System.lineSeparator());
        sb.append(" *Type: Fighter").append(System.lineSeparator());
        sb.append(super.toString());
        String mode = "ON";
        if(!this.aggressiveMode) {
            mode = "OFF";
        }
        sb.append(String.format(" *Aggressive Mode(%s)", mode)).append(System.lineSeparator());
        return sb.toString();
    }
}