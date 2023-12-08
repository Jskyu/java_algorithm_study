package programmers.level4.지형편집;

import java.util.*;

class Solution {
    public long solution(int[][] land, int P, int Q) {
        long answer = Long.MAX_VALUE;
        if (P == 0 || Q == 0 || land.length == 0) return 0;

        List<Integer> list = new ArrayList<>();
        long total = 0L;
        for (int[] arr : land) {
            for (int i : arr) {
                list.add(i);
                total += i;
            }
        }
        list.sort(Integer::compareTo);

        int beforeFloor = -1;
        long quantity = 0L;
        for (int i = 0; i < list.size(); i++) {
            int floor = list.get(i);
            if (beforeFloor != floor) {

                beforeFloor = floor;
                long plus = (long) floor * i - quantity;
                long minus = total - quantity - ((long) (list.size() - i) * floor);
                long result = (plus * P) + (minus * Q);
                if (answer > result) {
                    answer = result;
                }
            }
            quantity += list.get(i);
        }

        return answer;
    }

    public long solution2(int[][] land, int P, int Q) {
        long answer = -1;
        // p = 추가비용
        // q = 삭제비용
        if (P == 0 || Q == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        long maxFloor = 0;
        int minFloor = Integer.MAX_VALUE;
        for(int[] arr : land) {
            for(int nowFloor : arr) {
                for (int floor = 1; floor <= nowFloor; floor++) {
                    map.put(floor, map.getOrDefault(floor, 0) + 1);
                }

                maxFloor = Long.max(maxFloor, nowFloor);
                minFloor = (int) Long.min(minFloor, nowFloor);
            }
        }

        long plusCnt = 0L;
        long minusCnt = 0L;
        long perFloor = (long) land.length * land[0].length; // 한 층당 필요한 갯수

        for (int floor : map.keySet()) {
            if (floor == minFloor) continue;
            minusCnt += map.get(floor);
        }

        long before = minusCnt * Q;
        for (int nowFloor = minFloor + 1; nowFloor <= maxFloor; nowFloor++) {
            int nowFloorCount = map.getOrDefault(nowFloor, 0);
            minusCnt -= nowFloorCount;
            plusCnt += perFloor - nowFloorCount;

            long result = (plusCnt * P) + (minusCnt * Q);
            if (before > result) before = result;
            else break;
        }

        return before;
    }
}