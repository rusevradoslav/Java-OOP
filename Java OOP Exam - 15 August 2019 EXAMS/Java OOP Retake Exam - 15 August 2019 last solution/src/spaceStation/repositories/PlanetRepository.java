package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlanetRepository implements Repository<Planet> {

    private Collection<Planet> planetsRepository;

    public PlanetRepository() {
        this.planetsRepository = new ArrayList<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planetsRepository);
    }

    @Override
    public void add(Planet model) {
        if (!this.planetsRepository.contains(model)) {
            this.planetsRepository.add(model);
        }
    }

    @Override
    public boolean remove(Planet model) {
        return planetsRepository.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        Planet p = null;
        for (Planet planet : planetsRepository) {
            if (planet.getName().equals(name)) {
                p = planet;
            }
        }
        return p;
    }
}
