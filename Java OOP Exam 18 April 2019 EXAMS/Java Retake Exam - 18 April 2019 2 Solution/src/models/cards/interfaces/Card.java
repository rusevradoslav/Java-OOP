package models.cards.interfaces;

public interface Card {
    String getName();

    int getDamagePoints();

    void setDamagePoints(int damagePoints) throws IllegalArgumentException;

    int getHealthPoints();
}
