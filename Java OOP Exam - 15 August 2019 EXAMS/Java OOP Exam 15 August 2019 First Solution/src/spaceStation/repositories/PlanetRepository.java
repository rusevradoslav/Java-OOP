package spaceStation.repositories;

import spaceStation.models.planets.Planet;

import java.util.*;

public class PlanetRepository implements Repository<Planet> {
    private Set<Planet> planets;

    public PlanetRepository() {
        this.planets = new HashSet<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableSet(this.planets);
    }

    @Override
    public void add(Planet planet) {
        this.planets.add(planet);
    }

    @Override
    public boolean remove(Planet planet) {
        for (Planet p : this.planets) {
            if (p.getName().equals(planet.getName())) {
                this.planets.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public Planet findByName(String name) {
        for (Planet p : this.planets) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
}
