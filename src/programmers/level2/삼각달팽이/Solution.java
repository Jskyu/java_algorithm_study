package programmers.level2.삼각달팽이;

import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int maxNumber = (n + 1) * (n / 2);
        if (n % 2 == 1) maxNumber += (n + 1) / 2;
        int[] answer = new int[maxNumber];

        int[][] arr = new int[n][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }

        int number = 1;
        arr[0][0] = number++;

        int x = 0, y = 0;
        while (number <= maxNumber) {
            while (number <= maxNumber && y + 1 < arr.length && arr[y + 1][x] == 0) {
                arr[++y][x] = number++;
            }
            while (number <= maxNumber && x + 1 < arr[y].length && arr[y][x + 1] == 0) {
                arr[y][++x] = number++;
            }
            while (number <= maxNumber && arr[y - 1][x - 1] == 0) {
                arr[--y][--x] = number++;
            }
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }

    public int[] solution2(int n) {
        int[] answer = new int[(n*(n+1))/2];
        int[][] arr = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else {
                    --x;
                    --y;
                }
                arr[x][y] = num++;
            }
        }

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) break;
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}
