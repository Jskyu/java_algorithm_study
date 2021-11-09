package programmers.level1.numberAndAdditionOfFactors;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int left, int right) {
        AtomicInteger sum = new AtomicInteger();

        IntStream.range(left, right + 1).forEach(i -> {
            if( i % Math.sqrt(i) == 0) sum.addAndGet(-i);
            else sum.addAndGet(i);
        });

        return sum.get();
    }
}
