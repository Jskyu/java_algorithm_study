package programmers.pccp.t_t.n4_수레움직이기;

import java.util.Arrays;

class Solution {

    int[][] stats;
    int min = Integer.MAX_VALUE;
    int maxX = 0;
    int maxY = 0;
    public int solution(int[][] maze) {
        /*
        0 == 빈칸
        1 == 빨간수레 현재칸
        2 == 파란수레 현재칸
        3 == 빨간수레 도착칸
        4 == 파란수레 도착칸
        5 == 벽 == 둘 다 지나감
         */
        if (maze.length == 0) return 0;
        maxX = maze[0].length;
        maxY = maze.length;

        int redX = -1, redY = -1, blueX = -1, blueY = -1;

        for (int y = 0; y < maze.length; y++) {
            for (int x = 0; x < maze[y].length; x++) {
                if (maze[y][x] == 1) {
                    redX = x;
                    redY = y;
                    maze[y][x] = 0;
                }
                if (maze[y][x] == 2) {
                    blueX = x;
                    blueY = y;
                    maze[y][x] = 0;
                }
            }
            if (redX == redY && redY == blueX && blueX == blueY && blueY != -1) {
                break;
            }
        }

        dfs(redX, redY, blueX, blueY, 0, maze);
        if (min == Integer.MAX_VALUE) min = 0;

        return min;
    }

    public void dfs(int redX, int redY, int blueX, int blueY, int count, int[][] visit) {
        /*
        1 == 빨간수레 지나옴
        2 == 파란수레 지나옴
        3 == 빨간수레 도착칸
        4 == 파란수레 도착칸
        5 == 둘 다 지나옴 or 벽
        6 == 빨간수레 도착칸 & 파란수레 지나감
        8 == 파란수레 도착칸 & 빨간수레 지나감
        */
        if (visit[redY][redX] == 1 || visit[redY][redX] == 5 || visit[redY][redX] == 8 // 빨강 벽 또는 지나왔던곳
                || visit[blueY][blueX] == 2 || visit[blueY][blueX] == 5 || visit[blueY][blueX] == 6 // 파랑 벽 또는 지나왔던곳
                || (redX == blueX && redY == blueY) // 같은곳
        )
            return;

        if (visit[redY][redX] % 3 == 0 && visit[blueY][blueX] % 4 == 0) { // 둘 다 도착. return
            if (visit[redY][redX] != 0 && visit[blueY][blueX] != 0) {
                min = Math.min(min, count);
                return;
            }
        }

        int[][] clone = new int[visit.length][visit[0].length];
        for (int i = 0; i < visit.length; i++) {
            clone[i] = Arrays.copyOf(visit[i], visit[i].length);
        }

        if (clone[redY][redX] != 0 && clone[redY][redX] % 3 == 0) { // red는 도착. blue만 움직인다.
            // 움직임 처리
            switch (clone[blueY][blueX]) {
                case 0: // 빈칸이면 블루 지나감 처리
                    clone[blueY][blueX] = 2;
                    break;
                case 1: // 빨강이 자나간 자리는 벽으로 처리
                    clone[blueY][blueX] = 5;
                    break;
                case 3: // 빨강 도착칸은 * 2 처리
                    clone[blueY][blueX] = clone[blueY][blueX] * 2;
                    break;
                default: // 불가능!
                    throw new IllegalStateException("WTF!");
            }

            if (maxX > blueX + 1) {
                dfs(redX, redY, blueX + 1, blueY, count + 1, clone);
            }
            if (blueX > 0) {
                dfs(redX, redY, blueX - 1, blueY, count + 1, clone);
            }
            if (maxY > blueY + 1) {
                dfs(redX, redY, blueX, blueY + 1, count + 1, clone);
            }
            if (blueY > 0) {
                dfs(redX, redY, blueX, blueY - 1, count + 1, clone);
            }
        }
        else if (clone[blueY][blueX] != 0 && clone[blueY][blueX] % 4 == 0) { // blue는 도착. red만 움직인다.
            // 움직임 처리
            switch (clone[redY][redX]) {
                case 0: // 빈칸이면 레드 지나감 처리
                    clone[redY][redX] = 1;
                    break;
                case 2: // 파랑이 자나간 자리는 벽으로 처리
                    clone[redY][redX] = 5;
                    break;
                case 4: // 파랑 도착칸은 * 2 처리
                    clone[redY][redX] = clone[redY][redX] * 2;
                    break;
                default: // 불가능!
                    throw new IllegalStateException("WTF!");
            }
            if (maxX > redX + 1) {
                dfs(redX + 1, redY, blueX, blueY, count + 1, clone);
            }
            if (redX > 0) {
                dfs(redX - 1, redY, blueX, blueY, count + 1, clone);
            }
            if (maxY > redY + 1) {
                dfs(redX, redY + 1, blueX, blueY, count + 1, clone);
            }
            if (redY > 0) {
                dfs(redX, redY - 1, blueX, blueY, count + 1, clone);
            }
        }
        else { // 둘 다 움직인다.
            switch (clone[blueY][blueX]) {
                case 0: // 빈칸이면 블루 지나감 처리
                    clone[blueY][blueX] = 2;
                    break;
                case 1: // 빨강이 자나간 자리는 벽으로 처리
                    clone[blueY][blueX] = 5;
                    break;
                case 3: // 빨강 도착칸은 * 2 처리
                    clone[blueY][blueX] = clone[blueY][blueX] * 2;
                    break;
                default: // 불가능!
                    throw new IllegalStateException("WTF!");
            }
            switch (clone[redY][redX]) {
                case 0: // 빈칸이면 레드 지나감 처리
                    clone[redY][redX] = 1;
                    break;
                case 2: // 파랑이 자나간 자리는 벽으로 처리
                    clone[redY][redX] = 5;
                    break;
                case 4: // 파랑 도착칸은 * 2 처리
                    clone[redY][redX] = clone[redY][redX] * 2;
                    break;
                default: // 불가능!
                    throw new IllegalStateException("WTF!");
            }
            if (maxX > redX + 1) {
                if (maxX > blueX + 1) {
                    dfs(redX + 1, redY, blueX + 1, blueY, count + 1, clone);
                }
                if (blueX > 0) {
                    if (redY != blueY) { // 교차할 수 없다.
                        dfs(redX + 1, redY, blueX - 1, blueY, count + 1, clone);
                    }
                }
                if (maxY > blueY + 1) {
                    dfs(redX + 1, redY, blueX, blueY + 1, count + 1, clone);
                }
                if (blueY > 0) {
                    dfs(redX + 1, redY, blueX, blueY - 1, count + 1, clone);
                }
            }
            if (redX > 0) {
                if (maxX > blueX + 1) {
                    if (redY != blueY) { // 교차할 수 없다.
                        dfs(redX - 1, redY, blueX + 1, blueY, count + 1, clone);
                    }
                }
                if (blueX > 0) {
                    dfs(redX - 1, redY, blueX - 1, blueY, count + 1, clone);
                }
                if (maxY > blueY + 1) {
                    dfs(redX - 1, redY, blueX, blueY + 1, count + 1, clone);
                }
                if (blueY > 0) {
                    dfs(redX - 1, redY, blueX, blueY - 1, count + 1, clone);
                }
            }
            if (maxY > redY + 1) {
                if (maxX > blueX + 1) {
                    dfs(redX, redY + 1, blueX + 1, blueY, count + 1, clone);
                }
                if (blueX > 0) {
                    dfs(redX, redY + 1, blueX - 1, blueY, count + 1, clone);
                }
                if (maxY > blueY + 1) {
                    dfs(redX, redY + 1, blueX, blueY + 1, count + 1, clone);
                }
                if (blueY > 0) {
                    if (redX != blueX) { // 교차할 수 없다.
                        dfs(redX, redY + 1, blueX, blueY - 1, count + 1, clone);
                    }
                }
            }
            if (redY > 0) {
                if (maxX > blueX + 1) {
                    dfs(redX, redY - 1, blueX + 1, blueY, count + 1, clone);
                }
                if (blueX > 0) {
                    dfs(redX, redY - 1, blueX - 1, blueY, count + 1, clone);
                }
                if (maxY > blueY + 1) {
                    if (redX != blueX) { // 교차할 수 없다.
                        dfs(redX, redY - 1, blueX, blueY + 1, count + 1, clone);
                    }
                }
                if (blueY > 0) {
                    dfs(redX, redY - 1, blueX, blueY - 1, count + 1, clone);
                }
            }
        }
    }
}
