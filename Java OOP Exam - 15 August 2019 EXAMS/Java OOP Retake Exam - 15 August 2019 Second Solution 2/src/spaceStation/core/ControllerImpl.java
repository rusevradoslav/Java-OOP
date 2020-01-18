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

import java.util.*;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private Mission mission;
    private int explorePlanets = 0;

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
            return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronaut.getName());
        } else if (Geodesist.class.getSimpleName().equals(type)) {
            Astronaut astronaut = new Geodesist(astronautName);
            this.astronautRepository.add(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronaut.getName());
        } else if (Meteorologist.class.getSimpleName().equals(type)) {
            Astronaut astronaut = new Meteorologist(astronautName);
            this.astronautRepository.add(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronaut.getName());
        } else {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }

    }

    @Override
    public String addPlanet(String planetName, String... items) {
        if (planetName == null || planetName.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        Planet planet = new PlanetImpl(planetName);
        Collection<String> planetItems = planet.getItems();
        planetItems.addAll(Arrays.asList(items));
        this.planetRepository.add(planet);

        return String.format(ConstantMessages.PLANET_ADDED, planet.getName());
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = this.astronautRepository.getModels().stream().filter(astronaut1 -> astronaut1.getName().equals(astronautName)).findFirst().orElse(null);
        if (astronaut == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        } else {
            this.astronautRepository.remove(astronaut);
            return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        Planet planet = planetRepository.findByName(planetName);
        Collection<Astronaut> astronauts = this.astronautRepository
                .getModels()
                .stream()
                .filter(astronaut -> astronaut.getOxygen() > 60)
                .collect(Collectors.toCollection(ArrayList::new));

        if (astronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }
        mission.explore(planet, astronauts);
        this.explorePlanets++;
        long deadAstronautsCount = astronauts.stream().filter(astronaut -> astronaut.getOxygen() == 0).count();

        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, deadAstronautsCount);

    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, explorePlanets))
                .append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO);

        for (Astronaut model : astronautRepository.getModels()) {
            sb.append(System.lineSeparator()).append(model.toString());
        }
        return sb.toString();
    }
}
