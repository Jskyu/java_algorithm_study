package programmers.level2.쿼드압축_후_개수_세기;

import java.util.*;

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
