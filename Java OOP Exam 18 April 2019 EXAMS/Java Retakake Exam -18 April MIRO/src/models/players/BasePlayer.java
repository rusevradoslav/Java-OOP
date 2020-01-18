package models.players;

import models.players.interfaces.Player;
import repositories.interfaces.CardRepository;
import static common.ConstantMessages.*;

public abstract class BasePlayer implements Player {
    private static final int MIN_POINT_HEALTH = 0;
    private static final int MIN_POINT_DAMAGE = 0;

    private String username;
    private int health;
    private CardRepository cardRepository;
    private boolean isDead;

    protected BasePlayer(CardRepository cardRepository, String username, int health) {
        this.setUsername(username);
        this.setHealth(health);
        this.cardRepository = cardRepository;
        this.setDead(false);
    }

    @Override
    public void setHealth(int healthPoints) {
        if(healthPoints<MIN_POINT_HEALTH){
            throw new IllegalArgumentException(HEALTH_POINT_LESS_THAN_ZERO);
        }
        this.health = healthPoints;
    }

    private void setUsername(String username) {
        if(username==null || username.trim().isEmpty()){
            throw new IllegalArgumentException(NAME_IS_NULL_OR_EMPTY);
        }
        this.username = username;
    }

    private void setDead(boolean dead) {
        this.isDead = dead;
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
    public boolean isDead() {
        return this.isDead;
    }

    @Override
    public void takeDamage(int damagePoints) {
       if(damagePoints < MIN_POINT_DAMAGE){
           throw new IllegalArgumentException(DAMAGE_POINT_LESS_THAN_ZERO);
       }
       this.health -= damagePoints;
       if (this.health<=MIN_POINT_HEALTH){
           this.health = 0;
           this.isDead = true;
       }
    }
}
