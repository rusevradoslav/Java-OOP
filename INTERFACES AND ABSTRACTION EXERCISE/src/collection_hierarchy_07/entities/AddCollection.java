package collection_hierarchy_07.entities;

import collection_hierarchy_07.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    public AddCollection() {
    }


    @Override
    public int add(String item) {
        String temp = item;
        if (this.items.size() < maxSize) {
            items.add(temp);
        }
        return this.items.indexOf(temp);
    }
}
