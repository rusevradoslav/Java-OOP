package motocrossWorldChampionship.repositories;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_EXISTS;
import static motocrossWorldChampionship.common.ExceptionMessages.MOTORCYCLE_INVALID;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private Collection<Motorcycle> motorcycleRepository;

    public MotorcycleRepository() {
        this.motorcycleRepository = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        Motorcycle motorcycle = null;
        for (Motorcycle model : motorcycleRepository) {
            if(model.getModel().equals(name)){
                motorcycle = model;
            }
        }
        return motorcycle;
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.motorcycleRepository);
    }

    @Override
    public void add(Motorcycle model) {

        for (Motorcycle motorcycle : motorcycleRepository) {
            if (motorcycle.getModel().equals(model.getModel())) {
                throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model.getModel()));
            }
        }
        this.motorcycleRepository.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return false;
    }
}
