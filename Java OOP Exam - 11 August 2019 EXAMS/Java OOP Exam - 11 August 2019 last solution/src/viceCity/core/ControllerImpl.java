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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static viceCity.common.ConstantMessages.*;

public class ControllerImpl implements Controller {
    List<Player> civilPlayers;
    Queue<Gun> guns;
    Neighbourhood neighbourhood;
    Player mainPlayer;
    private static final String MAIN_PLAYER_FORNAME = "Vercetti";
    private static final String MAIN_PLAYER_NAME = "Tommy Vercetti";

    public ControllerImpl() {
        this.civilPlayers = new ArrayList<>();
        this.guns = new ArrayDeque<>();
        this.neighbourhood = new GangNeighbourhood();
        this.mainPlayer = new MainPlayer();
    }

    @Override

    public String addPlayer(String name) {
        Player player = new CivilPlayer(name);
        civilPlayers.add(player);
        return String.format(PLAYER_ADDED, name);
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (Pistol.class.getSimpleName().equals(type)) {
            gun = new Pistol(name);
            guns.offer(gun);
            return String.format(GUN_ADDED, name, type);
        }
        if (Rifle.class.getSimpleName().equals(type)) {
            gun = new Rifle(name);
            guns.offer(gun);
            return String.format(GUN_ADDED, name, type);
        }
        return String.format(GUN_TYPE_INVALID);
    }

    @Override
    public String addGunToPlayer(String name) {
        Gun gun1 = guns.peek();
        if (gun1 == null) {
            return GUN_QUEUE_IS_EMPTY;
        }
        if (MAIN_PLAYER_FORNAME.equals(name)) {
            Gun gun = guns.poll();
            mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), MAIN_PLAYER_NAME);
        }
        for (Player civilPlayer : civilPlayers) {
            if (civilPlayer.getName().equals(name)) {
                Gun gun = guns.poll();
                civilPlayer.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), name);
            }
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        neighbourhood.action(mainPlayer, civilPlayers);
        boolean isNotHarmed = civilPlayers.stream().allMatch(player -> player.getLifePoints() == 50);
        int deadCivilPlayers = (int) civilPlayers.stream().filter(player -> !player.isAlive()).count();

        if (mainPlayer.getLifePoints() == 100 && isNotHarmed) {
            return FIGHT_HOT_HAPPENED;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FIGHT_HAPPENED).append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE, mainPlayer.getLifePoints()))
                .append(System.lineSeparator())
                .append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers))
                .append(System.lineSeparator())
                .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE, civilPlayers.size() - deadCivilPlayers));


        return sb.toString().trim();
    }
}
