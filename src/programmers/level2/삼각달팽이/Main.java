package programmers.level2.삼각달팽이;

import java.util.Arrays;

/**<a href="https://school.programmers.co.kr/learn/courses/30/lessons/68645">삼각 달팽이</a>
 * 문제 설명
 * 정수 n이 매개변수로 주어집니다.
 * 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후,
 * 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 *
 * <img alt="examples.png" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e1e53b93-dcdf-446f-b47f-e8ec1292a5e0/examples.png">
 *
 * 제한사항
 * n은 1 이상 1,000 이하입니다.
 * 입출력 예
 * n	result
 * 4	[1,2,9,3,10,8,4,5,6,7]
 * 5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
 * 6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
 */
public class Main {
    public static void main(String[] args) {
        int[] n = {4, 5, 6};

        int[][] result = {
                {1, 2, 9, 3, 10, 8, 4, 5, 6, 7},
                {1, 2, 12, 3, 13, 11, 4, 14, 15, 10, 5, 6, 7, 8, 9},
                {1, 2, 15, 3, 16, 14, 4, 17, 21, 13, 5, 18, 19, 20, 12, 6, 7, 8, 9, 10, 11}
        };

        for (int i = 0; i < result.length; i++) {
            int[] answer = new Solution().solution(n[i]);
            int[] answer2 = new Solution().solution2(n[i]);
            System.out.println("case " + (i + 1) +
                    "\n정답: " + Arrays.toString(result[i]) +
                    "\n풀이1: " + Arrays.toString(answer) +
                    "\n풀이2: " + Arrays.toString(answer2) +
                    "\n");
        }
    }
}
