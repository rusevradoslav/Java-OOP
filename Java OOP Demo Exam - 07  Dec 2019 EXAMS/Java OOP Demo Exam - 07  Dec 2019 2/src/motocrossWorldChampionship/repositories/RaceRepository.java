package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.RACE_EXISTS;

public class RaceRepository implements Repository<Race> {
    private Collection<Race> raceRepository;

    public RaceRepository() {
        this.raceRepository = new ArrayList<>();
    }

    @Override
    public Race getByName(String name) {
        Race race = null;
        for (Race model : raceRepository) {
            if (model.getName().equals(name)) {
                race = model;
            }
        }
        return race;

    }

    @Override
    public Collection<Race> getAll() {
        return Collections.unmodifiableCollection(this.raceRepository);
    }

    @Override
    public void add(Race model) {
        for (Race race : raceRepository) {
            if (race.getName().equals(model.getName())) {
                throw new IllegalArgumentException(String.format(RACE_EXISTS, model.getName()));
            }
        }
        this.raceRepository.add(model);
    }

    @Override
    public boolean remove(Race model) {
        return this.raceRepository.remove(model);
    }
}
