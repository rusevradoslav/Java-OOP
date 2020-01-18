package spaceStation.models.astronauts;

public class Meteorologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN = 90;
    private static final double DECREASE_OXYGEN = 10;
    private static final double ZERO_OXYGEN = 0;

    public Meteorologist(String name) {
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
