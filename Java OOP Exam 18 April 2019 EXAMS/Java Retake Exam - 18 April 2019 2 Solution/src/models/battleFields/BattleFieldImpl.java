package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

public class BattleFieldImpl implements Battlefield {
    private static final int HEALTH_BONUS = 40;
    private static final int DAMAGE_BONUS = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) throws IllegalArgumentException {
        isDead(attackPlayer, enemyPlayer);
        isBeginner(attackPlayer);
        isBeginner(enemyPlayer);

        increaseHealth(attackPlayer);
        increaseHealth(enemyPlayer);

        letsFight(attackPlayer, enemyPlayer);

    }

    private void letsFight(Player attackPlayer, Player enemyPlayer) {
        while (true) {
            int attackerDamage = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
            enemyPlayer.takeDamage(attackerDamage);
            if (enemyPlayer.isDead()) {
                return;
            }
            int enemyDamage = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
            attackPlayer.takeDamage(enemyDamage);
            if (attackPlayer.isDead()) {
                return;
            }
        }

    }

    private void increaseHealth(Player player) {
        player.setHealth(player.getHealth() + player.getCardRepository()
                .getCards()
                .stream()
                .mapToInt(Card::getHealthPoints).sum());

    }

    private void isBeginner(Player player) {
        if (!Beginner.class.getSimpleName().equals(player.getUsername())) {
            return;
        }
        player.setHealth(player.getHealth() + HEALTH_BONUS);
        player.getCardRepository().getCards().forEach(card -> card.setDamagePoints(card.getDamagePoints() + DAMAGE_BONUS));

    }

    private void isDead(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException("Player is dead!");
        }
    }

}
