package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.RIDER_EXISTS;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> riderRepository;

    public RiderRepository() {
        this.riderRepository = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        Rider rider = null;
        for (Rider model : riderRepository) {
            if (model.getName().equals(name)) {
                rider = model;
            }
        }
        return rider;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.riderRepository);
    }

    @Override
    public void add(Rider model) {
        for (Rider rider : riderRepository) {
            if (rider.getName().equals(model.getName())) {
                throw new IllegalArgumentException(String.format(RIDER_EXISTS, model.getName()));
            }
        }
        this.riderRepository.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.riderRepository.remove(model);
    }
}
