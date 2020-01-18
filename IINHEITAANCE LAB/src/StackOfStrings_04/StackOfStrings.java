package StackOfStrings_04;

import java.util.ArrayList;

public class StackOfStrings<T>{
    private ArrayList<T> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(T element) {
        data.add(element);
    }

    public T pop() {
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop on empty Stack");
        }
        return data.remove(getLastIndex());
    }

    public T peek() {
        if (data.isEmpty()) {
            throw new IndexOutOfBoundsException("Cannot pop on empty Stack");
        }
        return data.get(getLastIndex());
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }

    private int getLastIndex() {
        return data.size() - 1;
    }
}
