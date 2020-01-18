package spaceStation.models.astronauts;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_NAME;
import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_OXYGEN;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO;

public abstract class BaseAstronaut implements Astronaut {
    private String name;
    private double oxygen;
    private Bag bag;
    private static final int DECREASE_OXYGEN_VALUE = 10;
    private static final int ZERO_OXYGEN = 0;

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
        return oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }


    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        if (oxygen < ZERO_OXYGEN) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        } else {
            this.oxygen = oxygen;
        }
    }
    @Override
    public String toString() {
        return String.format(REPORT_ASTRONAUT_NAME, this.getName())
                + System.lineSeparator()
                + String.format(REPORT_ASTRONAUT_OXYGEN, this.getOxygen())
                + System.lineSeparator()
                + this.bag.toString();
    }
}
