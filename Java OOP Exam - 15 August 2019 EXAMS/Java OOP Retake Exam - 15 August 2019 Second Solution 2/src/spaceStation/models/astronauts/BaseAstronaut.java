package spaceStation.models.astronauts;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

public abstract class BaseAstronaut implements Astronaut {
    private static final double ZERO_OXYGEN = 0;
    private String name;
    private double oxygen;
    private Bag bag;
    protected BaseAstronaut(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {

        return this.getOxygen() > ZERO_OXYGEN;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < ZERO_OXYGEN) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, this.name))
                .append(System.lineSeparator())
                .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, this.oxygen))
                .append(System.lineSeparator())
                .append(bag.toString());
        return sb.toString().trim();
    }
}
