package spaceStation.models.bags;

import spaceStation.common.ConstantMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {
    private List<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bag items: ");

        int countOfItems = items.size();
        if (items.isEmpty()) {
            sb.append("none");
        } else {
            String str = String.join(", ", items);
            sb.append(str);
        }
        return sb.toString().trim();
    }
}
