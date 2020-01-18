package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS;
import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER;

public class Backpack implements Bag {
    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (items.size() != 0) {
            stringBuilder.append(String.join(", ", getItems()));
        } else {
            stringBuilder.append("none");
        }
        return stringBuilder.toString().trim();
    }

}


