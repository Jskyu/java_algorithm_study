package kakao_blind.Y2021_Dev_Matching;

import kakao_blind.Y2021_Dev_Matching.lottoHigherLower.Lotto;

/*
 * lottos	                win_nums	                result
 * [44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	    [3, 5]
 * [0, 0, 0, 0, 0, 0]	    [38, 19, 20, 40, 15, 25]	[1, 6]
 * [45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	    [1, 1]
 */
public class Main {
    public static void main(String[] args) {
        Lotto q1 = new Lotto();
        int[] q1Lottos = {44, 1, 0, 0, 31, 25};
        int[] winNumbers = {31, 10, 45, 1, 6, 19};
        int[] q1Result = q1.solution(q1Lottos, winNumbers);
        System.out.println("Q1. Answer : " + (q1Result[0] == 3 && q1Result[1] == 5));
    }
}
