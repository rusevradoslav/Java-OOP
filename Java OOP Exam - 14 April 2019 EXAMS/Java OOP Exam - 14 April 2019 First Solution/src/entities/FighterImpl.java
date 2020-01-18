package entities;


public class FighterImpl extends BaseMachine {
    private static final double ATTACK_MOD = 50.0;
    private static final double DEFFENCE_MOD = 25.0;

    private boolean aggressiveMode;
    private double attackPointsModifier;
    private double defensePointsModifier;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 200);
        this.aggressiveMode = true;
        this.attackPointsModifier = ATTACK_MOD;
        this.defensePointsModifier = DEFFENCE_MOD;
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
      if(this.aggressiveMode){
          this.aggressiveMode = false;
          this.setAttackPoints(this.getAttackPoints()-this.attackPointsModifier);
          this.setDefensePoints(this.getDefensePoints()+this.defensePointsModifier);
      }else{
          this.aggressiveMode = true;
          this.setAttackPoints(this.getAttackPoints()+this.attackPointsModifier);
          this.setDefensePoints(this.getDefensePoints()-this.defensePointsModifier);
      }
    }

    @Override
    public String toString(){
        StringBuilder sb =new StringBuilder();
        sb.append(" *Type: Fighter").append(System.lineSeparator()).append(super.toString())
                .append(System.lineSeparator()).append(" *Aggressive Mode(");
        if(this.aggressiveMode){
            sb.append("ON)");
        }else {
            sb.append("OF)");
        }
        return sb.toString().trim();
    }

}
