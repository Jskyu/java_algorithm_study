package programmers.level3.SkillCheckLv3;

/**
 * n명의 사람이 일렬로 줄을 서고 있습니다. n명의 사람들에게는 각각 1번부터 n번까지 번호가 매겨져 있습니다.
 * n명이 사람을 줄을 서는 방법은 여러가지 방법이 있습니다. 예를 들어서 3명의 사람이 있다면 다음과 같이 6개의 방법이 있습니다.
 * <p>
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 * n	k	result
 * 3	5	[3,1,2]
 * 사람의 수 n과, 자연수 k가 주어질 때, 사람을 나열 하는 방법을 사전 순으로 나열 했을 때, k번째 방법을 return 하는 solution 함수를 완성해주세요.
 */

public class Main {
    public static void main(String[] args){

        SkillCheckLv3No1 skillCheckLv3No1 = new SkillCheckLv3No1();
        int n = 5;
        int k = 15;

        for(int i : skillCheckLv3No1.solution(n, k)){
            System.out.print(i + " ");
        }

    }
}
