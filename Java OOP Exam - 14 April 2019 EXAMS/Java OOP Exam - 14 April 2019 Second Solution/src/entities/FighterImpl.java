package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_POINTS_MODIFIER = 50.0;
    private static final double DEFENCE_POINTS_MODIFIER = 25.0;
    private boolean aggressiveMode;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.setAggressiveMode(true);
    }

    @Override
    public boolean getAggressiveMode() {

        return this.aggressiveMode;
    }

    private void setAggressiveMode(boolean aggressiveMode) {
        this.aggressiveMode = aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (getAggressiveMode()) {
            setAggressiveMode(false);
            super.setAttackPoints(super.getAttackPoints() + ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() - DEFENCE_POINTS_MODIFIER);
        } else {
            super.setAttackPoints(super.getAttackPoints() - ATTACK_POINTS_MODIFIER);
            super.setDefensePoints(super.getDefensePoints() + DEFENCE_POINTS_MODIFIER);
            setAggressiveMode(true);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append(" *Type: Fighter").append(System.lineSeparator()).append(super.toString())
                .append(System.lineSeparator()).append(" *Aggressive Mode(");
        if(this.aggressiveMode){
            sb.append("ON)");
        }else {
            sb.append("OF)");
        }
        return sb.toString().trim();
}}
