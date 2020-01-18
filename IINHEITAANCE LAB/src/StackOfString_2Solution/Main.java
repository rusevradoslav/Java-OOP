package StackOfString_2Solution;

public class Main {
    public static void main(String[] args) {

        CustomStack stack = new CustomStack();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("four");

        System.out.println(stack.isEmpty());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}
