package aquarium.models.aquariums;

import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        int sumComfort = 0;
        for (Decoration decoration : decorations) {
            sumComfort += decoration.getComfort();
        }
        return sumComfort;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.capacity > 0) {
            this.fish.add(fish);
            this.capacity--;
        } else {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removeFish(Fish fish) {
        if (!this.fish.contains(fish)) {
            this.fish.remove(fish);
        }
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : fish) {
            fish.eat();
        }
    }

    @Override
    public String getInfo() {
        String aquariumName = this.getName();
        String aquariumType = this.getClass().getSimpleName();
        String result = "";
        if (fish.isEmpty()) {
            result = "none";
        } else {
            for (Fish fish1 : fish) {
                result += (String.format(" %s",fish1.getName()));
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", aquariumName, aquariumType)).append(System.lineSeparator())
                .append(String.format("Fish:%s", result)).append(System.lineSeparator())
                .append(String.format("Decorations: %d", this.getDecorations().size())).append(System.lineSeparator())
                .append(String.format("Comfort: %d", calculateComfort())).append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }


}
