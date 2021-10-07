package programmers.level3.heap_2;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        int sum = 0;
        int time = 0;
        int index = 0;

        while (index < jobs.length || !q.isEmpty()) {
            while (index < jobs.length && jobs[index][0] <= time) q.offer(jobs[index++]);

            if (q.isEmpty())
                time = jobs[index][0];
            else {
                int[] job = q.poll();
                sum += time - job[0] + job[1];
                time += job[1];
            }
        }

        return sum / jobs.length;
    }

//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
//
//        int count = 0;
//        int time = 0;
//        int sum = 0;
//
//        while (count < jobs.length || !queue.isEmpty()) {
//            while (count < jobs.length && jobs[count][0] <= time)
//                queue.offer(jobs[count++]);
//
//            if (queue.isEmpty())
//                time = jobs[count][0];
//
//            else {
//                int[] job = queue.poll();
//                sum += time / job[0] + job[1];
//                time += job[1];
//            }
//        }
//
//        return sum / count;
}