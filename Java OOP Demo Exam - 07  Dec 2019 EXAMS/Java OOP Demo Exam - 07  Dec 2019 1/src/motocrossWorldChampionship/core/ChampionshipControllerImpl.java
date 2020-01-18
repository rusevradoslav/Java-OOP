package motocrossWorldChampionship.core;

import motocrossWorldChampionship.core.interfaces.ChampionshipController;
import motocrossWorldChampionship.entities.PowerMotorcycle;
import motocrossWorldChampionship.entities.RaceImpl;
import motocrossWorldChampionship.entities.RiderImpl;
import motocrossWorldChampionship.entities.SpeedMotorcycle;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.MotorcycleRepository;
import motocrossWorldChampionship.repositories.RaceRepository;
import motocrossWorldChampionship.repositories.RiderRepository;
import motocrossWorldChampionship.repositories.interfaces.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static motocrossWorldChampionship.common.ExceptionMessages.*;
import static motocrossWorldChampionship.common.OutputMessages.*;

public class ChampionshipControllerImpl implements ChampionshipController {

    private static final String SPEED_TYPE_MOTOR = "Speed";
    private static final String POWER_TYPE_MOTOR = "Power";
    private Repository<Motorcycle> motorcycleRepository;
    private Repository<Rider> riderRepository;
    private Repository<Race> raceRepository;

    public ChampionshipControllerImpl(
            Repository<Rider> riderRepository,
            Repository<Motorcycle> motorcycleRepository,
            Repository<Race> raceRepository) {

        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createRider(String riderName) {
        Rider rider = new RiderImpl(riderName);
        riderRepository.add(rider);
        return String.format(RIDER_CREATED, riderName);
    }

    @Override
    public String createMotorcycle(String type, String model, int horsePower) {
        for (Motorcycle motorcycle1 : motorcycleRepository.getAll()) {
            if (motorcycle1.getModel().equals(model)) {
                throw new IllegalArgumentException(String.format(MOTORCYCLE_EXISTS, model));
            }
        }
        Motorcycle motorcycle = null;
        if (SPEED_TYPE_MOTOR.equals(type)) {
            motorcycle = new SpeedMotorcycle(model, horsePower);
        } else if (POWER_TYPE_MOTOR.equals(type)) {
            motorcycle = new PowerMotorcycle(model, horsePower);
        }
        this.motorcycleRepository.add(motorcycle);
        return String.format(MOTORCYCLE_CREATED, motorcycle.getClass().getSimpleName(), motorcycle.getModel());
    }


    @Override
    public String addMotorcycleToRider(String riderName, String motorcycleModel) {
        Rider rider = riderRepository.getByName(riderName);

        if (this.motorcycleRepository.getByName(motorcycleModel) == null) {
            throw new NullPointerException(String.format(MOTORCYCLE_NOT_FOUND, motorcycleModel));
        }
        if (rider == null) {
            throw new NullPointerException(String.format(RIDER_NOT_FOUND, riderName));
        }
        Motorcycle motorcycle = this.motorcycleRepository.getByName(motorcycleModel);

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
        return String.format(RIDER_ADDED, rider.getName(), race.getName());
    }

    @Override
    public String startRace(String raceName) {
        Race race = this.raceRepository.getByName(raceName);
        if (race == null) {
            throw new NullPointerException(String.format(RACE_NOT_FOUND, raceName));
        }
        List<Rider> riders = new ArrayList<>(race.getRiders());
        if (riders.size() < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, race.getName(), 3));
        }
        riders = riders.stream().sorted((f, s) -> (int)
                (s.getMotorcycle().calculateRacePoints(race.getLaps()) - f.getMotorcycle().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());
        riders.get(0).winRace();
        this.raceRepository.remove(race);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(RIDER_FIRST_POSITION, riders.get(0).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(RIDER_SECOND_POSITION, riders.get(1).getName(), race.getName()))
                .append(System.lineSeparator())
                .append(String.format(RIDER_THIRD_POSITION, riders.get(2).getName(), race.getName()))
                .append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        Race race = new RaceImpl(name, laps);
        raceRepository.add(race);
        return String.format(RACE_CREATED, name);
    }
}
