package programmers.level1.mutualEvaluation;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        /*int[][] scores = {
                {100, 90, 98, 88, 65},
                {50, 45, 99, 85, 77},
                {47, 88, 95, 80, 67},
                {61, 57, 100, 80, 65},
                {24, 90, 94, 75, 65}};*/
/*
    0   1
0   50  90
1   50  87
 */
        int[][] scores = {
                {50, 90},
                {50, 87}
        };

        String result = s.solution(scores);

        System.out.println("result = " + result);
    }
}
