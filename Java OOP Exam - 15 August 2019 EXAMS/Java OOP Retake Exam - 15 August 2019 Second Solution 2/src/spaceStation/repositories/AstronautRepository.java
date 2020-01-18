package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class AstronautRepository implements Repository<Astronaut> {

    private Set<Astronaut> astronautsCollection;

    public AstronautRepository() {
        this.astronautsCollection = new LinkedHashSet<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableSet(this.astronautsCollection);
    }

    @Override
    public void add(Astronaut model) {
        this.astronautsCollection.add(model);
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronautsCollection.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut astronaut = null;
        for (Astronaut astr : astronautsCollection) {
            if (astr.getName().equals(name)) {
                astronaut = astr;
            }
        }
        return astronaut;
    }
}
