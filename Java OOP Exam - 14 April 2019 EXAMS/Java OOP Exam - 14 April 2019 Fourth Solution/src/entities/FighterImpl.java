package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double INITIAL_HEALTH_POINTS = 200;
    private static final double ATTACK_MODIFIER = 50.0;
    private static final double DEFENSE_MODIFIER = 25.0;

    private boolean aggressiveMode;


    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.aggressiveMode = true;
        modifyMod();
    }

    private void modifyMod() {
        double defencePoints = super.getDefensePoints();
        double attackpoints = super.getAttackPoints();
        if (this.aggressiveMode) {
            attackpoints += ATTACK_MODIFIER;
            defencePoints -= DEFENSE_MODIFIER;
        } else {
            attackpoints -= ATTACK_MODIFIER;
            defencePoints += DEFENSE_MODIFIER;
        }
        this.setAttackPoints(attackpoints);
        this.setDefensePoints(defencePoints);
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        this.aggressiveMode = !this.aggressiveMode;
        modifyMod();
    }

    @Override
    public String toString() {
        String mode = this.getAggressiveMode() ? "ON" : "OFF";
        return super.toString() + String.format(" *Aggressive Mode(%s)", mode);
    }
}
