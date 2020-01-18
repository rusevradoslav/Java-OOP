package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

import static motocrossWorldChampionship.common.ExceptionMessages.RACE_EXISTS;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> raceCollection;

    public RaceRepository() {
        this.raceCollection = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;
        for (Race model : raceCollection) {
            if (model.getName().equals(name)) {
                race = model;
            }
        }
        return race;

    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.raceCollection);
    }

    @Override
    public void add(Race model) {
        for (Race race : raceCollection) {
            if (raceCollection.contains(model)) {
                throw new IllegalArgumentException(String.format(RACE_EXISTS, model.getName()));
            }
        }

        raceCollection.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.raceCollection.remove(model);
    }
}
