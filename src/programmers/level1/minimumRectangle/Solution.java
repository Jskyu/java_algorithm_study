package programmers.level1.minimumRectangle;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;

        for (int[] size : sizes) {
            int max = Math.max(size[0], size[1]);
            int min = Math.min(size[0], size[1]);

            maxW = Math.max(maxW, max);
            maxH = Math.max(maxH, min);
        }

        return maxW * maxH;
    }

    public int solution2(int[][] sizes) {
        return Arrays.stream(sizes).reduce((a, b) -> new int[]{
                Math.max(Math.max(a[0], a[1]), Math.max(b[0], b[1])), Math.max(Math.min(a[0], a[1]), Math.min(b[0], b[1]))
        }).map(it -> it[0] * it[1]).orElse(0);
    }
}
