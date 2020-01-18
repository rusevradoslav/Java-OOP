package military_elite_04.military.interfaces;

import military_elite_04.military.entities.Missions;
import military_elite_04.military.enumerations.State;

import java.util.Collection;


public interface Commando extends SpecialisedSoldier {
    void addMission(Missions missions);
    Collection<Missions> getMissions();
}
