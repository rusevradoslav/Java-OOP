package spaceStation.repositories;

import spaceStation.models.astronauts.Astronaut;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AstronautRepository implements Repository<Astronaut> {
    private Collection<Astronaut> astronautsRepository;

    public AstronautRepository() {
        this.astronautsRepository = new ArrayList<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronautsRepository);
    }

    @Override
    public void add(Astronaut model) {
        if (!astronautsRepository.contains(model)) {
            this.astronautsRepository.add(model);
        }
    }

    @Override
    public boolean remove(Astronaut model) {
        return this.astronautsRepository.remove(model);
    }

    @Override
    public Astronaut findByName(String name) {
        Astronaut a = null;
        for (Astronaut astronaut : astronautsRepository) {
            if (astronaut.getName().equals(name)) {
                a = astronaut;
            }
        }
        return a;
    }
}
