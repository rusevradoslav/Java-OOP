package models.players;

import models.cards.interfaces.Card;
import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;

import static common.ConstantMessages.DEFAULT_REPORT_SEPARATOR;
import static common.ConstantMessages.PLAYER_REPORT_INFO;

public abstract class BasePlayer implements Player {
    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;
    private static final int DAMAGE_MIN_POINT = 0;
    private static final int HEALTH_MIN_POINT = 0;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        this.setDead(false);
    }

    @Override
    public CardRepository getCardRepository() {
        return this.cardRepository;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void setHealth(int healthPoints) throws IllegalArgumentException {
        if (healthPoints < HEALTH_MIN_POINT) {
            throw new IllegalArgumentException("Player's health bonus cannot be less than zero. ");
        }
        this.health = healthPoints;
    }

    @Override
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) throws IllegalArgumentException {
        if (damagePoints < DAMAGE_MIN_POINT) {
            throw new IllegalArgumentException("Damage points cannot be less than zero.");
        }
        if (this.health - damagePoints < DAMAGE_MIN_POINT) {
            this.setDead(true);
            this.setHealth(HEALTH_MIN_POINT);
        } else {
            this.setHealth(this.getHealth() - damagePoints);
        }
    }

    private void setUsername(String username) throws IllegalArgumentException {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Player's username cannot be null or an empty string. ");
        }
        this.username = username;
    }

    private void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public String toString() {
        int cardCount = this.getCardRepository().getCount();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PLAYER_REPORT_INFO, this.getUsername(), this.getHealth(), cardCount)).append(System.lineSeparator());
        for (Card card : cardRepository.getCards()) {
            sb.append(card.toString()).append(System.lineSeparator());
        }
        sb.append(DEFAULT_REPORT_SEPARATOR);
        return sb.toString().trim();
    }
}
