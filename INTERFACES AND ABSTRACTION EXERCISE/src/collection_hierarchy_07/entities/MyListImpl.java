package collection_hierarchy_07.entities;

import collection_hierarchy_07.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    private int used;

    public MyListImpl() {
    }

    @Override
    public int getUsed() {
        return this.used = getSize();
    }

    @Override
    public String remove() {
        String item = items.get(0);
        if (!this.items.isEmpty()) {
            items.remove(item);
        }else {
            return "";
        }
        return item;
    }

    @Override
    public int add(String item) {
        String temp = item;
        if (items.size() < maxSize) {
            items.add(0, temp);
        }
        return items.indexOf(item);
    }
}
