package programmers.level3.heap_3;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (String str : operations) {
            String order = str.split(" ")[0];
            int num = Integer.parseInt(str.split(" ")[1]);

            switch (order) {
                case "I":
                    maxQ.add(num);
                    break;
                case "D":
                    if(maxQ.isEmpty()) continue;
                    else if (num == 1) {
                        maxQ.remove();
                    } else if (num == -1) {
                        Queue<Integer> minQ = new PriorityQueue<>();

                        minQ.addAll(maxQ);
                        minQ.remove();

                        maxQ.clear();
                        maxQ.addAll(minQ);
                    }
                    break;
            }
        }

        if (maxQ.isEmpty()) return new int[]{0, 0};
        int max = maxQ.peek();
        int min = maxQ.poll();
        while (!maxQ.isEmpty()) {
            min = maxQ.poll();
        }
        return new int[]{max, min};
    }
}
