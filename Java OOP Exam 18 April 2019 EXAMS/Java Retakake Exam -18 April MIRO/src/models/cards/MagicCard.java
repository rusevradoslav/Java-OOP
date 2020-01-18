package models.cards;

public class MagicCard extends BaseCard {
    private static final int INIT_DAMAGE_POINTS = 5;
    private static final int INIT_HEALTH_POINTS = 80;

    public MagicCard(String name) {
        super(name, INIT_DAMAGE_POINTS, INIT_HEALTH_POINTS);
    }
}
