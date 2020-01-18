package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player player : civilPlayers) {
            for (Gun gun : mainPlayer.getGunRepository().getModels()) {
                while (player.isAlive() && gun.canFire()) {
                    player.takeLifePoints(gun.fire());
                }
                if (!player.isAlive()) {
                    break;
                }
            }
        }

        for (Player player: civilPlayers){
            if(player.isAlive()){
                for (Gun gun: player.getGunRepository().getModels()){
                    while (gun.canFire() && mainPlayer.isAlive()){
                        mainPlayer.takeLifePoints(gun.fire());
                    }
                    if(!mainPlayer.isAlive()){
                        break;
                    }
                }
            }
            if(!mainPlayer.isAlive()){
                break;
            }
        }
    }
}
