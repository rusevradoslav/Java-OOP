package aquarium.core;

import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;
import aquarium.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.decorations = new DecorationRepository();
        this.aquariums = new ArrayList<>();
    }

    @Override

    public String addAquarium(String aquariumType, String aquariumName) {
        if ("FreshwaterAquarium".equals(aquariumType)) {
            Aquarium aquarium = new FreshwaterAquarium(aquariumName);
            aquariums.add(aquarium);
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        } else if ("SaltwaterAquarium".equals(aquariumType)) {
            Aquarium aquarium = new SaltwaterAquarium(aquariumName);
            aquariums.add(aquarium);
            return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
        } else {
            throw new IllegalArgumentException(INVALID_AQUARIUM_TYPE);
        }
    }


    @Override
    public String addDecoration(String type) {
        if ("Ornament".equals(type)) {
            Decoration decoration = new Ornament();
            decorations.add(decoration);
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        } else if ("Plant".equals(type)) {
            Decoration decoration = new Plant();
            decorations.add(decoration);
            return String.format(SUCCESSFULLY_ADDED_DECORATION_TYPE, type);
        } else {
            throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration currDecoration = decorations.findByType(decorationType);
        if (currDecoration == null) {
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(currDecoration);
                decorations.remove(currDecoration);
            }
        }

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Aquarium currAquarium = null;
        if ("FreshwaterFish".equals(fishType)) {
            Fish fish = new FreshwaterFish(fishName, fishSpecies, price);
            for (Aquarium aquarium : aquariums) {
                if (aquariumName.equals(aquarium.getClass().getSimpleName())) {
                    aquarium.addFish(fish);

                    currAquarium = aquarium;
                } else {
                    return String.format(WATER_NOT_SUITABLE);
                }
            }

        } else if ("SaltwaterFish".equals(fishType)) {
            Fish fish = new SaltwaterFish(fishName, fishSpecies, price);
            for (Aquarium aquarium : aquariums) {
                if (aquariumName.equals(aquarium.getClass().getSimpleName())) {
                    aquarium.addFish(fish);
                    currAquarium = aquarium;
                } else {
                    return String.format(WATER_NOT_SUITABLE);
                }
            }
        } else {
            throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, currAquarium.getName());
    }


    @Override
    public String feedFish(String aquariumName) {
        int fishFeedCount = 0;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                for (Fish fish : aquarium.getFish()) {
                    fish.eat();
                    fishFeedCount++;
                }
            }
        }
        return String.format(FISH_FED, fishFeedCount);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double value = 0;
        for (Aquarium aquarium : aquariums) {
            double decorationValue = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
            double fishValue = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
            double result = decorationValue + fishValue;
            value = result;
        }
        return String.format(VALUE_AQUARIUM, aquariumName, value);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
