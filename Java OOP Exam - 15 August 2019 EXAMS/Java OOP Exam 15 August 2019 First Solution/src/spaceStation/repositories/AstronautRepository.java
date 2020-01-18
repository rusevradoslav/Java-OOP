package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.*;

public class AstronautRepository implements Repository<Astronaut> {
    private Set<Astronaut> astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashSet<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableSet(this.astronauts);
    }

    @Override
    public void add(Astronaut model) {
        if (!this.astronauts.contains(model)) {
            this.astronauts.add(model);
        }
    }

    @Override
    public boolean remove(Astronaut model) {
        boolean isRemoved = false;
        if (this.astronauts.contains(model)) {
            this.astronauts.remove(model);
        }
        return isRemoved;
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut astronaut = null;
        for (Astronaut a : astronauts) {
            if (a.getName().equals(name)) {
                astronaut = a;
            }
        }
        return astronaut;
    }
}
