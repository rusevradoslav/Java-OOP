package motocrossWorldChampionship.entities;

import static motocrossWorldChampionship.common.ExceptionMessages.INVALID_HORSE_POWER;

public class SpeedMotorcycle extends MotorcycleImpl {

    private static final double CUBIC_CENTIMETERS_DEFAULT = 125;
    private static final int MIN_HORSEPOWER = 50;
    private static final int MAX_HORSEPOWER = 69;

    public SpeedMotorcycle(String model, int horsePower) {
        super(model, horsePower, CUBIC_CENTIMETERS_DEFAULT);
    }

    @Override
    protected void setHorsePower(int horsePower) {
        if (horsePower < MIN_HORSEPOWER || horsePower > MAX_HORSEPOWER) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        super.setHorsePower(horsePower);
    }
}
