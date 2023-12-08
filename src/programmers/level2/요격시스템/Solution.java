package programmers.level2.요격시스템;

import java.util.*;

class Solution {

    public int solution(int[][] targets) {
        Arrays.sort(targets, (arr1, arr2) -> {
            if (arr1[1] == arr2[1]) {
                return Integer.compare(arr1[0], arr2[0]);
            }
            return Integer.compare(arr1[1], arr2[1]);
        });

        int answer = 0;
        int point = 0;
        for (int[] target : targets) {
            if (target[0] >= point) {
                point = target[1];
                answer++;

            };
        }

        return answer;
    }
}