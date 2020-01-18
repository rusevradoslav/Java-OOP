package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.*;

import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_EXISTS;

public class MotorcycleRepository implements Repository<Motorcycle> {
    private Collection<Motorcycle> motorcyclesCollection;

    public MotorcycleRepository() {
        this.motorcyclesCollection = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        Motorcycle motorcycle = null;
        for (Motorcycle model : motorcyclesCollection) {
            if(model.getModel().equals(name)){
                motorcycle = model;
            }
        }
        return motorcycle;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.motorcyclesCollection);
    }

    @Override
    public void add(Motorcycle model) {
        for (Motorcycle motorcycle : motorcyclesCollection) {
            if (motorcyclesCollection.contains(model)) {
                throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model.getModel()));
            }
        }
        this.motorcyclesCollection.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.motorcyclesCollection.remove(model);
    }
}
