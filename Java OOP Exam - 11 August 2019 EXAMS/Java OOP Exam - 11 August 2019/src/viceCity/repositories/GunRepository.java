package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.*;

public class GunRepository implements Repository<Gun> {
    private List<Gun> gunRepository;

    public GunRepository() {
        this.gunRepository = new LinkedList<>();
    }

    @Override

    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(this.gunRepository);
    }

    @Override
    public void add(Gun model) {
        if (!gunRepository.contains(model)) {
            gunRepository.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        boolean isRemoved = false;
        if (gunRepository.contains(model)) {
            gunRepository.remove(model);
            isRemoved = true;
        }
        return isRemoved;
    }

    @Override
    public Gun find(String name) {
        Gun gun = null;
        for (Gun gun1 : gunRepository) {
            if (gun1.getName().equals(name)) {
                gun = gun1;
            }
        }
        return gun;
    }
}
