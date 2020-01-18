package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class PlanetRepository implements Repository<Planet> {
    private Set<Planet> planetsCollection;


    public PlanetRepository() {
        this.planetsCollection = new LinkedHashSet<>();

    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableSet(this.planetsCollection);
    }

    @Override
    public void add(Planet model) {
        this.planetsCollection.add(model);
    }

    @Override
    public boolean remove(Planet model) {
        return this.planetsCollection.remove(model);
    }

    @Override
    public Planet findByName(String name) {
        Planet planet = null;
        for (Planet planet1 : planetsCollection) {
            if (planet1.getName().equals(name)) {
                planet = planet1;
            }
        }
        return planet;
    }
}
