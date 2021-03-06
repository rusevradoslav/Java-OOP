package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final int DECREASE_OXYGEN_VALUE = 5;
    private static final int ZERO_OXYGEN = 0;
    private static int INITIAL_OXYGEN = 70;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        if (this.getOxygen() - DECREASE_OXYGEN_VALUE >= ZERO_OXYGEN) {
            this.setOxygen(this.getOxygen() - DECREASE_OXYGEN_VALUE);
        } else {
            this.setOxygen(ZERO_OXYGEN);
        }
    }
}
