package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {
    private static final String POWER_MOTORCYCLE = "Power";
    private static final String SPEED_MOTORCYCLE = "Speed";
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Rider> riderRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(Repository<Rider> riderRepository, Repository<Motorcycle> motorcycleRepository, Repository<Race> raceRepository) {
        this.motorcycleRepository = motorcycleRepository;
        this.riderRepository = riderRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        Rider rider = new RiderImpl(riderName);
        this.riderRepository.add(rider);
        return String.format(RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        ////proverka za dali syshtestvuva
        Motorcycle motorcycle = null;
        if (POWER_MOTORCYCLE.equals(type)) {
            motorcycle = new PowerMotorcycle(model, horsePower);
        }
        if (SPEED_MOTORCYCLE.equals(type)) {
            motorcycle = new SpeedMotorcycle(model, horsePower);
        }

        motorcycleRepository.add(motorcycle);
        return String.format(MOTORCYCLE_CREATED, motorcycle.getClass().getSimpleName(), motorcycle.getModel());
    }

    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = riderRepository.getByName(riderName);
        Motorcycle motorcycle = motorcycleRepository.getByName(motorcycleModel);


        if (rider == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }
        if (motorcycle == null) {
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }

        rider.addMotorcycle(motorcycle);

        return String.format(MOTORCYCLE_ADDED, riderName, motorcycleModel);
    }

    @Override
    public String addRiderToRace(String raceName, String riderName) {
        Race race = raceRepository.getByName(raceName);
        Rider rider = riderRepository.getByName(riderName);

        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }
        if (rider == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }

        race.addRider(rider);
        return String.format(RIDER_ADDED, riderName, raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }

        Comparator<Rider> riderComparator = (f, s) -> (int)
                (s.getMotorcycle().calculateRacePoints(race.getLaps()) - f.getMotorcycle().calculateRacePoints(race.getLaps()));
        ArrayList<Rider> sortedRiders = race.getRiders().stream().sorted(riderComparator).collect(Collectors.toCollection(ArrayList::new));
        if (sortedRiders.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, raceName, 3));
        }
        StringBuilder sb = new StringBuilder();
        sb
                .append(System.lineSeparator())
                .append(String.format(RIDER_FIRST_POSITION, sortedRiders.get(0).getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(RIDER_SECOND_POSITION, sortedRiders.get(1).getName(), raceName))
                .append(System.lineSeparator())
                .append(String.format(RIDER_THIRD_POSITION, sortedRiders.get(2).getName(), raceName));
        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        this.raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
