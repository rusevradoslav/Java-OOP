package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> gunsCollection;

    public GunRepository() {
        this.gunsCollection = new ArrayList();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.gunsCollection);
    }

    @Override
    public void add(Gun model) {
        if (!gunsCollection.contains(model)) {
            this.gunsCollection.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return gunsCollection.remove(model);
    }

    @Override
    public Gun find(String name) {
        Gun gun = gunsCollection.stream().filter(gun1 -> gun1.getName().equals(name)).findFirst().orElse(null);
        return gun;
    }
}
