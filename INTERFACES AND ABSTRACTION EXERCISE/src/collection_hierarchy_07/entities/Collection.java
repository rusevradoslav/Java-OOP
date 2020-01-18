package collection_hierarchy_07.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    public int maxSize = 100;
    public List<String> items;

    protected Collection() {
        this.items = new ArrayList<>(maxSize);
    }


    protected int getSize() {
        return this.items.size();
    }


}
