package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double INITIAL_HEALTH_POINTS = 100;
    private static final double ATTACK_MODIFIER = 40.0;
    private static final double DEFENSE_MODIFIER = 30.0;

    private boolean defenseMode;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, INITIAL_HEALTH_POINTS);
        this.defenseMode = true;
        modifyMod();
    }

    private void modifyMod() {
        double attackPoints = this.getAttackPoints();
        double defencePoints = this.getDefensePoints();
        if (defenseMode) {
            attackPoints -= ATTACK_MODIFIER;
            defencePoints += DEFENSE_MODIFIER;
        } else {
            attackPoints += ATTACK_MODIFIER;
            defencePoints -= DEFENSE_MODIFIER;
        }
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defencePoints);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        this.defenseMode = !this.defenseMode;
        modifyMod();
    }

    @Override
    public String toString() {
        String mode = this.getDefenseMode() ? "ON" : "OFF";
        return super.toString() + String.format(" *Defense Mode(%s)", mode);
    }
}


