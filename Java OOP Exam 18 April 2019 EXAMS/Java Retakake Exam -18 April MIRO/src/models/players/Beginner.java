package models.players;

import repositories.interfaces.CardRepository;

public class Beginner extends BasePlayer {
    private static final int INIT_HEALTH = 50;

    public Beginner(CardRepository cardRepository, String username) {
        super(cardRepository, username, INIT_HEALTH);
    }
}
