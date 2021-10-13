package programmers.level3.heap_3;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        Arrays.stream(operations).forEach(str -> {
            String[] split = str.split(" ");
            String order = split[0];
            int num = Integer.parseInt(str.split(" ")[1]);

            switch (order) {
                case "I":
                    maxQ.add(num);
                    break;
                case "D":
                    if (!maxQ.isEmpty()) {
                        if (num == 1) {
                            maxQ.remove();
                        } else if (num == -1) {
                            removeMin(maxQ);
                        }
                    }
                    break;
            }
        });

        return getResult(maxQ);
    }

    private int[] getResult(Queue<Integer> maxQ) {
        if (maxQ.isEmpty()) return new int[]{0, 0};
        int max = maxQ.peek();
        int min = maxQ.poll();
        while (!maxQ.isEmpty()) {
            min = maxQ.poll();
        }
        return new int[]{max, min};
    }

    private void removeMin(Queue<Integer> maxQ) {
        Queue<Integer> minQ = new PriorityQueue<>();

        minQ.addAll(maxQ);
        minQ.remove();

        maxQ.clear();
        maxQ.addAll(minQ);
    }
}
