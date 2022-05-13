package programmers.level1.findRemainder1;

import java.util.stream.IntStream;

public class Solution {
    public int solution(int n) {
        long start = System.currentTimeMillis();
        try {
            return IntStream.range(2, n).filter(i -> n % i == 1).findFirst().orElse(0);
        } finally {
            System.out.println("time : " + (System.currentTimeMillis() - start) + "ms");
        }
    }
}
