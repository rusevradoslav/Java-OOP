package spaceStation.models.astronauts;

public class Meteorologist  extends BaseAstronaut{
    private static final double INITIAL_OXYGEN = 90;
    private static final double DECREASE_OXYGEN_POINTS = 10;
    private static final double ZERO_OXYGEN = 0;

    public Meteorologist(String name) {
        super(name, INITIAL_OXYGEN);
    }


    @Override
    public void breath() {
        if (this.getOxygen() - DECREASE_OXYGEN_POINTS < 0) {
            this.setOxygen(ZERO_OXYGEN);
        } else {
            this.setOxygen(this.getOxygen() - DECREASE_OXYGEN_POINTS);
        }
    }
}
