package military_elite_04.military.entities;

import military_elite_04.military.enumerations.Corp;
import military_elite_04.military.interfaces.Commando;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Set<Missions> missions;


    public CommandoImpl(int id, String name, String lastName, double salary, Corp corps) {
        super(id, name, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }


    @Override
    public void addMission(Missions mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Missions> getMissions() {
        return this.missions;
    }

    public void completeMission() {
        for (Missions mission : missions) {
            mission.setState();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator());
        sb.append("Missions:").append(System.lineSeparator());
        for (Missions mission : missions) {
            sb.append(mission.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
