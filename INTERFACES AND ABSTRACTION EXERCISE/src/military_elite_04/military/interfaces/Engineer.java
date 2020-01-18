package military_elite_04.military.interfaces;

import military_elite_04.military.entities.Repair;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier {
    void addRepair(Repair repair);
  Collection<Repair> getRepairs();
}
