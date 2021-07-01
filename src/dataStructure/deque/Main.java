package dataStructure.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            deque.addFirst(i + 1);
        }

        System.out.println(deque.offerFirst(5));

        for (Integer integer : deque) {
            System.out.println("integer = " + integer);
        }
    }
}
