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


public class ManagerControllerImpl implements ManagerController {
    private static final String PLAYER_ADDED = "Successfully added player of type %s with username: %s";
    private static final String CARD_ADDED = "Successfully added card of type %sCard with name: %s";
    private static final String CARD_ADDED_TO_PLAYER = "Successfully added card: %s to user: %s";
    private static final String FIGHT_RESULT = "Attack user health %d - Enemy user health %d";


    private PlayerRepository players;
    private CardRepository cards;
    private Battlefield battlefield;

    public ManagerControllerImpl() {
        players = new PlayerRepositoryImpl();
        cards = new CardRepositoryImpl();
        battlefield = new BattleFieldImpl();
    }

    @Override
    public String addPlayer(String type, String username) {
        Player player = null;
        if(type.equals(Beginner.class.getSimpleName())){
            player = new Beginner(new CardRepositoryImpl(),username);
        }else if(type.equals(Advanced.class.getSimpleName())){
            player = new Advanced(new CardRepositoryImpl(),username);
        }
        this.players.add(player);
        return  String.format(PLAYER_ADDED,type,username);
    }

    @Override
    public String addCard(String type, String name) {
        Card card = null;
        if(type.equals("Magic")){
            card = new MagicCard(name);
        }else if(type.equals("Trap")){
            card = new TrapCard(name);
        }
        this.cards.add(card);
        return  String.format(CARD_ADDED,type,name);
    }

    @Override
    public String addPlayerCard(String username, String cardName) {
        Player player = this.players.find(username);
        Card card = this.cards.find(cardName);
        player.getCardRepository().add(card);
        return  String.format(CARD_ADDED_TO_PLAYER,cardName,username);
    }

    @Override
    public String fight(String attackUser, String enemyUser) {
        Player attacker = this.players.find(attackUser);
        Player enemy = this.players.find(enemyUser);
        this.battlefield.fight(attacker,enemy);
        return  String.format(FIGHT_RESULT,attacker.getHealth(),enemy.getHealth());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Player p: this.players.getPlayers()){
            sb.append("Username: ").append(p.getUsername()).append(" - Health: ").append(p.getHealth())
                    .append(" - Cards ").append(p.getCardRepository().getCards().size()).append(System.lineSeparator());
            if(p.getCardRepository().getCards().size()!=0){
                for (Card c: p.getCardRepository().getCards()){
                    sb.append("Card: ").append(c.getName()).append(" - Damage: ").append(c.getDamagePoints())
                            .append(System.lineSeparator());
                }
            }
            sb.append("###").append(System.lineSeparator());
        }

        return  sb.toString().trim();
    }
}
