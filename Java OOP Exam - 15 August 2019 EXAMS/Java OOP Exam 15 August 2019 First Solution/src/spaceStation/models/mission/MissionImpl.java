package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            if (!astronaut.canBreath() && astronaut.getOxygen() >= 50) {
                break;
            }
            String item1 = null;
            for (String item : planet.getItems()) {
                if (!astronaut.canBreath()) {
                    break;
                }
                astronaut.breath();
                astronaut.getBag().getItems().add(item);
                item1 = item;
            }
            planet.getItems().remove(item1);

        }
    }
}
