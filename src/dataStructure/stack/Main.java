package dataStructure.stack;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 10; i+=2) {
            stack.add(i + 1);
        }

        for (Integer integer : stack) {
            System.out.println("integer = " + integer);
        }
    }
}
