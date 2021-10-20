package programmers.level2.h_index;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solution(int[] citations) {
//        List<Integer> list = Arrays.stream(citations).boxed()
//                .sorted(Collections.reverseOrder()).collect(Collectors.toList());
//        int count = 0;
//        //12, 9, 9, 9
//        for (int i : list) {
//            if (count < i) {
//                if (i == 0) return count;
//                else count++;
//            } return count;
//        }

        AtomicInteger h = new AtomicInteger(0);
        return (int) Arrays.stream(citations).boxed()
                .sorted(Collections.reverseOrder()).unordered()
                .filter(i -> h.getAndIncrement() < i && i != 0)
                .count();
    }
}
