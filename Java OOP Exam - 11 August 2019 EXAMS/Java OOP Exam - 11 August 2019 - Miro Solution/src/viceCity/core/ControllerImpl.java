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
    private Player mainPlayer;
    private Collection<Player> civilPlayers;
    private ArrayDeque<Gun> repository;
    private Neighbourhood neighbourhood;


    public ControllerImpl() {
        mainPlayer = new MainPlayer();
        civilPlayers = new ArrayList<>();
        repository = new ArrayDeque<Gun>();
        this.neighbourhood = new GangNeighbourhood();
    }

    @Override
    public String addPlayer(String name) {
        this.civilPlayers.add(new CivilPlayer(name));
        return String.format(PLAYER_ADDED,name);
    }

    @Override
    public String addGun(String type, String name) {
        if(guns.PISTOL.toString().equals(type.toUpperCase())){
            this.repository.offer(new Pistol(name));
            return String.format(GUN_ADDED,name,type);
        }
        if(guns.RIFLE.toString().equals(type.toUpperCase())){
            this.repository.offer(new Rifle(name));
            return String.format(GUN_ADDED,name,type);
        }
        return GUN_TYPE_INVALID;
    }

    @Override
    public String addGunToPlayer(String name) {
        if(this.repository.isEmpty()){
            return GUN_QUEUE_IS_EMPTY;
        }
        if(name.equals("Vercetti")){
            Gun gun = this.repository.pop();
            this.mainPlayer.getGunRepository().add(gun);
            return String.format(GUN_ADDED_TO_MAIN_PLAYER,gun.getName(),this.mainPlayer.getName());
        }

        for(Player player: this.civilPlayers){
            if(player.getName().equals(name)){
                Gun gun = this.repository.pop();
                player.getGunRepository().add(gun);
                return String.format(GUN_ADDED_TO_CIVIL_PLAYER,gun.getName(),name);
            }
        }
        return CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
     this.neighbourhood.action(this.mainPlayer,this.civilPlayers);
        StringBuilder sb = new StringBuilder();
      if(this.mainPlayer.getLifePoints()==100 && this.civilPlayers.stream().allMatch(pl -> pl.getLifePoints()==50)) {
          return FIGHT_HOT_HAPPENED;
      }else{

          sb.append(FIGHT_HAPPENED).append(System.lineSeparator()).append(String.format(MAIN_PLAYER_LIVE_POINTS_MESSAGE,mainPlayer.getLifePoints()))
                  .append(System.lineSeparator());
          long alivePlayers = this.civilPlayers.stream().filter(Player::isAlive).count();
          long deadPlayers = this.civilPlayers.size() - alivePlayers;
          sb.append(String.format(MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE,deadPlayers)).append(System.lineSeparator())
                  .append(String.format(CIVIL_PLAYERS_LEFT_MESSAGE,alivePlayers));
      }
      return sb.toString().trim();
    }


    private enum guns{
        PISTOL,
        RIFLE
    }
}
