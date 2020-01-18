package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {

            if (!astronaut.canBreath() && astronaut.getOxygen() >= 50) {
                break;
            }

            Collection<String> collection = new ArrayList<>(planet.getItems());
            String item = null;
            for (String s : collection) {
                if (astronaut.getOxygen()==0){
                    break;
                }
                astronaut.breath();
                astronaut.getBag().getItems().add(s);
                item = s;
                planet.getItems().remove(item);
            }
        }
    }
}
