package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

import static motocrossWorldChampionship.common.ExceptionMessages.RIDER_EXISTS;

public class RiderRepository implements Repository<Rider> {
    private Collection<Rider> ridersCollection;

    public RiderRepository() {
        this.ridersCollection = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        Rider rider = null;
        for (Rider model : ridersCollection) {
            if (model.getName().equals(name)) {
                rider = model;
            }
        }
        return rider;
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.ridersCollection);
    }

    @Override
    public void add(Rider model) {
        for (Rider rider : ridersCollection) {
            if (rider.getName().equals(model.getName())) {
                throw new IllegalArgumentException(String.format(RIDER_EXISTS, model.getName()));
            }
        }
        ridersCollection.add(model);
        // if (ridersCollection.contains(model)) {
        //     throw new IllegalArgumentException(String.format(RIDER_EXISTS, model.getName()));
        // }
    }

    @Override
    public boolean remove(Rider model) {
        return this.ridersCollection.remove(model);
    }
}
