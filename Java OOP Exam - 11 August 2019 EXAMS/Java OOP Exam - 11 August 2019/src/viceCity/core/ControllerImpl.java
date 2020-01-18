package viceCity.core;

import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.*;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    private static final String MAIN_PLAYER_FORNAME = "Vercetti";
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";

    private Player mainPlayer;
    private Queue<Gun> guns;
    private Collection<Player> civilPlayers;
    private Neighbourhood neighbourhood;

    public ControllerImpl() {
        this.mainPlayer = new MainPlayer();
        this.guns = new ArrayDeque<>();
        this.civilPlayers = new ArrayList<>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        this.civilPlayers.add(player);

        return String.format(PLAYER_ADDED, player.getName());

    }

    @Override
    public String addGun(String type, String name) {
        if (Pistol.class.getSimpleName().equals(type)) {
            Gun gun = new Pistol(name);
            guns.offer(gun);
        } else if (Rifle.class.getSimpleName().equals(type)) {
            Gun gun1 = new Rifle(name);
            guns.offer(gun1);
        } else {
            return GUN_TYPE_INVALID;
        }
        return String.format(GUN_ADDED, name, type);

    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun = guns.peek();
        if (gun == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (MAIN_PLAYER_FORNAME.equals(name)) {
            Gun gun1 = guns.poll();
            mainPlayer.getGunRepository().add(gun1);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun1.getName(), MAIN_PLAYER_NAME);
        }

        Player civilPlayer = civilPlayers.stream().filter(player -> player.getName().equals(name)).findFirst().orElse(null);
        if (civilPlayer == null) {
            return CIVIL_PLAYER_DOES_NOT_EXIST;
        } else {
            Gun gun1 = guns.poll();
            civilPlayer.getGunRepository().add(gun1);
            return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun1.getName(), civilPlayer.getName());
        }

    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers);
        boolean isCivilAreHarmed = civilPlayers.stream().allMatch(player -> player.getLifePoints() == 50);
        long deadCivilPlayers = civilPlayers.stream().filter(player -> !player.isAlive()).count();
        StringBuilder sb = new StringBuilder();

        if (mainPlayer.getLifePoints() == 100 && isCivilAreHarmed) {
            sb.append(FIGHT_HOT_HAPPENED);
        } else {
            sb.append(FIGHT_HAPPENED).append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadCivilPlayers))
                    .append(System.lineSeparator());
        }


        return sb.toString().trim();

    }
}
