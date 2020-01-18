package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 70;
    private static final double DECREASE_OXYGEN = 5;
    private static final double ZERO_OXYGEN = 0;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN);
    }

    @Override
    public void breath() {
        if (super.getOxygen() - DECREASE_OXYGEN >= ZERO_OXYGEN) {
            super.setOxygen(super.getOxygen() - DECREASE_OXYGEN);
        }
        if (!canBreath()) {
            super.setOxygen(ZERO_OXYGEN);
        }
    }
}
