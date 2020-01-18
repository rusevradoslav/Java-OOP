package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static spaceStation.common.ConstantMessages.*;
import static spaceStation.common.ExceptionMessages.ASTRONAUT_INVALID_TYPE;

public class ControllerImpl implements Controller {

    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int explorePlanetCount = 0;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {

        if (Biologist.class.getSimpleName().equals(type)) {
            Astronaut astronaut = new Biologist(astronautName);
            this.astronautRepository.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else if (Geodesist.class.getSimpleName().equals(type)) {
            Astronaut astronaut = new Geodesist(astronautName);
            this.astronautRepository.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else if (Meteorologist.class.getSimpleName().equals(type)) {
            Astronaut astronaut = new Meteorologist(astronautName);
            this.astronautRepository.add(astronaut);
            return String.format(ASTRONAUT_ADDED, type, astronautName);
        } else {
            throw new IllegalArgumentException(ASTRONAUT_INVALID_TYPE);
        }
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        if (planetName == null || planetName.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }

        Planet planet = new PlanetImpl(planetName);
        Collections.addAll(planet.getItems(), items);
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if (!astronautRepository.getModels().contains(astronaut)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        astronautRepository.remove(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> suitableAstronauts = astronautRepository.getModels().stream().filter(astronaut -> astronaut.getOxygen() > 60).collect(Collectors.toList());
        if (suitableAstronauts.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        Planet planet = planetRepository.findByName(planetName);
        mission.explore(planet, suitableAstronauts);
        long deadAstronautsCount = suitableAstronauts.stream().filter(astronaut -> astronaut.getOxygen() == 0).count();
        explorePlanetCount++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronautsCount);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(REPORT_PLANET_EXPLORED, this.explorePlanetCount)).append(System.lineSeparator())
                .append(String.format(REPORT_ASTRONAUT_INFO));
        for (Astronaut model : astronautRepository.getModels()) {
            sb.append(System.lineSeparator()).append(model.toString());
        }
        return sb.toString().trim();
    }
}
