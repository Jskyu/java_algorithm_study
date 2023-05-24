package programmers.level3.triangle;

import java.util.Arrays;

public class Solution {

    /**
            7                  30
           3 8               23  21
          8 1 0      =>    20  13  10
         2 7 4 4         7   12  10  10
        4 5 2 6 5      4   5   2   6   5
    */
    public int dp_reverse(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }

        return triangle[0][0];
    }


    /**
            7                   7
           3 8               10  15
          8 1 0      =>    18  16  15
         2 7 4 4         20  25  20  19
        4 5 2 6 5      24  30  27  26  24
    */
    public int dp(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];

            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j], triangle[i - 1][j - 1]);
            }

            triangle[i][i] = triangle[i - 1][i - 1] + triangle[i][i];
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().orElse(0);
    }

    public int dp2(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];

            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }

            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        return Arrays.stream(dp[triangle.length - 1]).max().orElse(0);
    }
}