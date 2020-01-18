package models.cards;

public class TrapCard extends BaseCard {
    private static final int INIT_DAMAGE_POINTS = 120;
    private static final int INIT_HEALTH_POINTS = 5;

    public TrapCard(String name) {
        super(name, INIT_DAMAGE_POINTS, INIT_HEALTH_POINTS);
    }
}
