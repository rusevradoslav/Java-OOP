package models.battleFields;

import models.battleFields.interfaces.Battlefield;
import models.cards.interfaces.Card;
import models.players.Beginner;
import models.players.interfaces.Player;

import static common.ConstantMessages.*;

public class BattleFieldImpl implements Battlefield {
    private static final int HEALTH_BONUS = 40;
    private static final int DAMAGE_BONUS = 30;

    @Override
    public void fight(Player attackPlayer, Player enemyPlayer) {
        if (attackPlayer.isDead() || enemyPlayer.isDead()) {
            throw new IllegalArgumentException(PLAYER_IS_DEAD);
        }
        isBeginner(attackPlayer);
        isBeginner(enemyPlayer);

        getCardsHealth(attackPlayer);
        getCardsHealth(enemyPlayer);

       Fight(attackPlayer,enemyPlayer);


    }

    private void Fight(Player attackPlayer, Player enemyPlayer) {
        int attackDamage = attackPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        int enemyDamage = enemyPlayer.getCardRepository().getCards().stream().mapToInt(Card::getDamagePoints).sum();
        while (true) {
            enemyPlayer.takeDamage(attackDamage);
            if (enemyPlayer.isDead()) {
                break;
            }
            attackPlayer.takeDamage(enemyDamage);
            if (attackPlayer.isDead()) {
                break;
            }
        }
    }

    private void getCardsHealth(Player player) {
        int cardsHealth = player.getCardRepository().getCards().stream().mapToInt(Card::getHealthPoints).sum();
        player.setHealth(player.getHealth()+cardsHealth);
    }

    private void isBeginner(Player player) {
        if (player.getClass().getSimpleName().equals(Beginner.class.getSimpleName())) {
            player.setHealth(player.getHealth() + HEALTH_BONUS);
            player.getCardRepository().getCards().forEach(c -> c.setDamagePoints(c.getDamagePoints() + DAMAGE_BONUS));
        }
    }
}
