package core;

import core.interfaces.ManagerController;
import models.battleFields.BattleFieldImpl;
import models.battleFields.interfaces.Battlefield;
import models.cards.MagicCard;
import models.cards.TrapCard;
import models.cards.interfaces.Card;
import models.players.Advanced;
import models.players.Beginner;
import models.players.interfaces.Player;
import repositories.CardRepositoryImpl;
import repositories.PlayerRepositoryImpl;
import repositories.interfaces.CardRepository;
import repositories.interfaces.PlayerRepository;

import static common.ConstantMessages.*;


public class ManagerControllerImpl implements ManagerController {
    private static final String MAGIC_CARD = "Magic";
    private static final String TRAP_CARD = "Trap";
    private PlayerRepository playerRepository;
    private CardRepository cardRepository;
    private Battlefield battlefield;


    public ManagerControllerImpl() {
        this.playerRepository = new PlayerRepositoryImpl();
        this.cardRepository = new CardRepositoryImpl();
        this.battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        if (Beginner.class.getSimpleName().equals(type)) {
            player = new Beginner(new CardRepositoryImpl(), username);
        } else if (Advanced.class.getSimpleName().equals(type)) {
            player = new Advanced(new CardRepositoryImpl(), username);
        }
        playerRepository.add(player);
        String message = String.format(SUCCESSFULLY_ADDED_PLAYER, type, username);
        return message;
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        if (MAGIC_CARD.equals(type)) {
            card = new MagicCard(name);
        } else if (TRAP_CARD.equals(type)) {
            card = new TrapCard(name);
        }
        String message = String.format(SUCCESSFULLY_ADDED_CARD, type, name);
        return message;
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = playerRepository.find(username);
        Card card = cardRepository.find(cardName);
        player.getCardRepository().getCards().add(card);
        String message = String.format(SUCCESSFULLY_ADDED_PLAYER_WITH_CARDS, card.getName(), username);
        return message;
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = playerRepository.find(attackUser);
        Player enemy = playerRepository.find(enemyUser);
        battlefield.fight(attacker, enemy);
        String message = String.format(FIGHT_INFO, attacker.getHealth(), enemy.getHealth());
        return message;
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player player : playerRepository.getPlayers()) {
            sb.append(player.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
