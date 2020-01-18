package collection_hierarchy_07.entities;

import collection_hierarchy_07.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
    }

    @Override
    public String remove() {
        String item = null;
        if (!this.items.isEmpty()) {
            items.remove(item);
            item= items.get(items.size() - 1);
        }
        return item;
    }

    @Override
    public int add(String item) {
        String temp = item;
        if (items.size() < maxSize) {
            items.add(0, temp);
        }
        return items.indexOf(temp);
    }
}
