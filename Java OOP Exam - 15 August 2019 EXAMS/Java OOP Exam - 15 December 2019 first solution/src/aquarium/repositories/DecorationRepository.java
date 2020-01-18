package aquarium.repositories;

import aquarium.models.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        if (!decorations.contains(decoration)) {
            decorations.add(decoration);
        }
    }

    @Override
    public boolean remove(Decoration decoration) {
        return decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        Decoration currDecoration = null;
        for (Decoration decoration1 : decorations) {
            if (decoration1.getClass().getSimpleName().equals(type)) {
                currDecoration = decoration1;
            }
        }
        return currDecoration;
    }
}
