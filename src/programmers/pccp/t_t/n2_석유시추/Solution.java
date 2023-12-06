package programmers.pccp.t_t.n2_석유시추;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int[][] visit;
    List<Oil> oilList = new ArrayList<>();

    int maxX = 0;
    int maxY = 0;
    public int solution(int[][] land) {
        int answer = 0;
        if (land.length == 0) return 0;
        maxX = land[0].length;
        maxY = land.length;

        // visit 0 == 맨땅 or 확인한곳
        visit = land;

        extract();

        for (int y = 0; y < land[0].length; y++) {
            int count = 0;
            for (Oil list : oilList) {
                count += list.getCountByY(y);
                answer = Math.max(answer, count);
            }
        }

        return answer;
    }

    private void extract() {
        int index = 0;
        for (int y = 0; y < visit.length; y++) {
            for (int x = 0; x < visit[y].length; x++) {
                if (visit[y][x] == 1) {
                    oilList.add(new Oil());
                    dfs(x, y, index++);
                }
            }
        }
    }

    private void dfs(int x, int y, int index) {
        // visit 0 == 맨땅 or 확인한곳
        visit[y][x] = 0;
        oilList.get(index).add(x);

        if (maxY > y + 1 && visit[y + 1][x] == 1) {
            dfs(x, y + 1, index);
        }
        if (y > 0 && visit[y - 1][x] == 1) {
            dfs(x, y - 1, index);
        }
        if (maxX > x + 1 && visit[y][x + 1] == 1) {
            dfs(x + 1, y, index);
        }
        if (x > 0 && visit[y][x - 1] == 1) {
            dfs(x - 1, y, index);
        }
    }

    static class Oil {
        int count = 0;
        int minX = Integer.MAX_VALUE;
        int maxX = 0;

        void add(int x) {
            count++;
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
        }

        int getCountByY(int y) {
            return minX <= y && y <= maxX ? count : 0;
        }
    }
}