package programmers.level2.쿼드압축_후_개수_세기;

import java.util.*;

/*
테스트 1 〉	통과 (0.38ms, 73.3MB)
테스트 2 〉	통과 (0.55ms, 79.1MB)
테스트 3 〉	통과 (0.18ms, 85.1MB)
테스트 4 〉	통과 (0.07ms, 76.1MB)
테스트 5 〉	통과 (35.94ms, 92.4MB)
테스트 6 〉	통과 (10.49ms, 88.6MB)
테스트 7 〉	통과 (4.60ms, 102MB)
테스트 8 〉	통과 (3.55ms, 88MB)
테스트 9 〉	통과 (6.15ms, 85.2MB)
테스트 10 〉	통과 (5.69ms, 130MB)
테스트 11 〉	통과 (0.14ms, 77.6MB)
테스트 12 〉	통과 (0.05ms, 71.4MB)
테스트 13 〉	통과 (7.19ms, 97.3MB)
테스트 14 〉	통과 (10.74ms, 122MB)
테스트 15 〉	통과 (11.32ms, 121MB)
테스트 16 〉	통과 (4.76ms, 99.5MB)
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int[] solution(int[][] arr) {
        map.put(0, 0);
        map.put(1, 0);
        dfs(0, 0, arr.length, arr);

        return new int[]{map.get(0), map.get(1)};
    }

    private void dfs(int y, int x, int size, int[][] arr) {
        if (check(arr, size, x, y)) {
            map.put(arr[y][x], map.get(arr[y][x]) + 1);
            return;
        }

        int nextSize = size / 2;
        dfs(y, x, nextSize, arr);
        dfs(y, x + nextSize, nextSize, arr);
        dfs(y + nextSize, x, nextSize, arr);
        dfs(y + nextSize, x + nextSize, nextSize, arr);
    }

    private boolean check(int[][] arr, int n, int x, int y) {
        int val = arr[y][x];
        for (int i = y; i < n + y; i++) {
            for (int j = x; j < n + x; j++) {
                if (val != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
