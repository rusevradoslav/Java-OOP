package StackOfString_2Solution;

import java.util.ArrayDeque;
import java.util.Stack;

public class CustomStack<T> extends ArrayDeque<T> {
    private ArrayDeque<T> stack;

    public CustomStack() {
        this.stack = new ArrayDeque<T>();
    }

    public void push(T element) {
        super.push(element);
    }

    public T pop() {
        if (super.isEmpty()){
            throw new IndexOutOfBoundsException("Cannot pop on empty stack!");
        }
        return super.pop();
    }

    public T peek() {
        if (super.isEmpty()){
            throw new IndexOutOfBoundsException("Cannot peek on empty stack!");
        }
        return super.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
