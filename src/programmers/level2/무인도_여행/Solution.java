package programmers.level2.무인도_여행;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] solution(String[] maps) {
        List<Land> list = new ArrayList<>();

        int[][] arr = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arr[i][j] = chars[j] == 'X' ? -1 : Character.getNumericValue(chars[j]);
            }
        }

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                if (arr[y][x] != -1) {
                    Land land = new Land();
                    find(y, x, arr, land);
                    list.add(land);
                }
            }
        }
        return list.isEmpty() ? new int[]{-1} : list.stream().map(Land::getTotal).sorted(Integer::compareTo).mapToInt(i -> i).toArray();
    }

    private void find(int y, int x, int[][] arr, Land land) {
        if (arr[y][x] == -1) return;

        land.food.add(arr[y][x]);
        arr[y][x] = -1;

        if (arr.length > y + 1) find(y + 1, x, arr, land);
        if (0 <= y - 1) find(y - 1, x, arr, land);
        if (arr[y].length > x + 1) find(y, x + 1, arr, land);
        if (0 <= x - 1) find(y, x - 1, arr, land);
    }

    private class Land {
        final List<Integer> food = new ArrayList<>();

        private int getTotal() {
            return food.stream().mapToInt(i -> i).sum();
        }
    }
}