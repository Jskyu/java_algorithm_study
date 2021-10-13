package programmers.level3.heap_3;

import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        q.add(3);
        q.add(2);
        q.add(1);

        while (!q.isEmpty()) {
            System.out.print(q.peek() + " ");
            q.remove();
        }
    }
}
