package entities;


public class TankImpl extends BaseMachine {
    private static final double ATTACK_MOD = 40.0;
    private static final double DEFFENCE_MOD = 30.0;

    private boolean defenseMode;
    private double attackPointsModifier;
    private double defensePointsModifier;


    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name, attackPoints, defensePoints, 100);
        this.defenseMode = true;
        this.attackPointsModifier = ATTACK_MOD;
        this.defensePointsModifier = DEFFENCE_MOD;
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode(){
        if(this.defenseMode){
            this.defenseMode = false;
            this.setAttackPoints(this.getAttackPoints()+this.attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints()-this.defensePointsModifier);
        }else{
            this.defenseMode = true;
            this.setAttackPoints(this.getAttackPoints()-this.attackPointsModifier);
            this.setDefensePoints(this.getDefensePoints()+this.defensePointsModifier);
        }
    }

    @Override
    public String toString(){
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
