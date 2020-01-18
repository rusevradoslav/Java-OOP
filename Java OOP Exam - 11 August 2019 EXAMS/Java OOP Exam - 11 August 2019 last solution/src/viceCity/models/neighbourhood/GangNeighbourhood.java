package viceCity.models.neighbourhood;

import viceCity.models.guns.Gun;
import viceCity.models.players.Player;

import java.util.Collection;

public class GangNeighbourhood implements Neighbourhood {
    @Override
    public void action(Player mainPlayer, Collection<Player> civilPlayers) {
        for (Player civilPlayer : civilPlayers) {
            for (Gun model : mainPlayer.getGunRepository().getModels()) {
                while (model.canFire() && !civilPlayers.isEmpty()) {
                    civilPlayer.takeLifePoints(model.fire());
                    if (!civilPlayer.isAlive()) {
                        break;
                    }
                }
            }
        }

        for (Player civilPlayer : civilPlayers) {
            if (!civilPlayer.isAlive()) {
                continue;
            }
            for (Gun model : civilPlayer.getGunRepository().getModels()) {
                while (model.canFire() && mainPlayer.isAlive()) {
                    mainPlayer.takeLifePoints(model.fire());
                    if (!mainPlayer.isAlive()) {
                        break;
                    }
                }
            }
            if (!mainPlayer.isAlive()) {
                break;
            }
        }
    }
}
