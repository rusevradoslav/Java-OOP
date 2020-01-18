package StackOfStrings_04;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackOfStrings<Character> stack = new StackOfStrings<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');

        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
