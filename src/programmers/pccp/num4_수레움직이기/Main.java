package programmers.pccp.num4_수레움직이기;

/** <a href="https://school.programmers.co.kr/learn/courses/30/lessons/250134">수레 움직이기</a>
 * 문제 설명
 * n x m 크기 격자 모양의 퍼즐판이 주어집니다.
 *
 * 퍼즐판에는 빨간색 수레와 파란색 수레가 하나씩 존재합니다. 각 수레들은 자신의 시작 칸에서부터 자신의 도착 칸까지 이동해야 합니다.
 * 모든 수레들을 각자의 도착 칸으로 이동시키면 퍼즐을 풀 수 있습니다.
 *
 * 당신은 각 턴마다 반드시 모든 수레를 상하좌우로 인접한 칸 중 한 칸으로 움직여야 합니다. 단, 수레를 움직일 때는 아래와 같은 규칙이 있습니다.
 *
 * 수레는 벽이나 격자 판 밖으로 움직일 수 없습니다.
 * 수레는 자신이 방문했던 칸으로 움직일 수 없습니다.
 * 자신의 도착 칸에 위치한 수레는 움직이지 않습니다. 계속 해당 칸에 고정해 놓아야 합니다.
 * 동시에 두 수레를 같은 칸으로 움직일 수 없습니다.
 * 수레끼리 자리를 바꾸며 움직일 수 없습니다.
 * 예를 들어, 아래 그림처럼 n = 3, m = 2인 퍼즐판이 있습니다.
 *
 * <img alt="rb_horse1.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/2d21a258-144f-4d03-81c1-1a857a942efa/rb_horse1.jpg">
 *
 * 속이 빨간색인 원은 빨간색 수레를 나타냅니다.
 * 속이 파란색인 원은 파란색 수레를 나타냅니다.
 * 테두리가 빨간색인 원은 빨간색 수레의 도착 칸을 나타냅니다.
 * 테두리가 파란색인 원은 파란색 수레의 도착 칸을 나타냅니다.
 * 위 퍼즐판은 아래와 같은 순서로 3턴만에 풀 수 있습니다.
 *
 * <img alt="rb_horse2.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/e1c81aa3-238b-4f0e-b21d-697903543b72/rb_horse2.jpg">
 *
 * 빨간색 사선이 처진 칸은 빨간색 수레가 방문했던 칸을 나타냅니다. 규칙에 따라 빨간색 수레는 빨간색 사선이 처진 칸(방문했던 칸)으로는 이동할 수 없습니다.
 * 파란색 사선이 처진 칸은 파란색 수레가 방문했던 칸을 나타냅니다. 규칙에 따라 파란색 수레는 파란색 사선이 처진 칸(방문했던 칸)으로는 이동할 수 없습니다.
 * <img alt="rb_horse3.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/2b78f38c-121a-441c-90f9-704eb0642e96/rb_horse3.jpg">
 *
 * 위처럼 동시에 수레를 같은 칸으로 움직일 수는 없습니다.
 * 퍼즐판의 정보를 나타내는 2차원 정수 배열 maze가 매개변수로 주어집니다. 퍼즐을 푸는데 필요한 턴의 최솟값을 return 하도록 solution 함수를 완성해 주세요. 퍼즐을 풀 수 없는 경우 0을 return 해주세요.
 *
 * 제한사항
 * 1 ≤ maze의 길이 (= 세로 길이) ≤ 4
 *
 * 1 ≤ maze[i]의 길이 (= 가로 길이) ≤ 4
 * maze[i][j]는 0,1,2,3,4,5 중 하나의 값을 갖습니다.
 * maze[i][j]	의미
 * 0	빈칸
 * 1	빨간 수레의 시작 칸
 * 2	파란 수레의 시작 칸
 * 3	빨간 수레의 도착 칸
 * 4	파란 수레의 도착 칸
 * 5	벽
 * 빨간 수레의 시작 칸, 빨간 수레의 도착 칸, 파란 수레의 시작 칸, 파란 수레의 도착 칸은 퍼즐판에 1개씩 존재합니다.
 *
 * 입출력 예
 * maze	                                            result
 * [[1, 4], [0, 0], [2, 3]]	                        3
 * [[1, 0, 2], [0, 0, 0], [5, 0 ,5], [4, 0, 3]]	    7
 * [[1, 5], [2, 5], [4, 5], [3, 5]]	                0
 * [[4, 1, 2, 3]]	                                0
 *
 * 입출력 예 설명
 * 입출력 예 #1
 * 문제 예시와 같습니다.
 *
 * 입출력 예 #2
 * <img alt="rb_horse4.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/54629429-3bec-4288-a7b4-6303c0929880/rb_horse4.jpg">
 * 7턴만에 퍼즐을 풀 수 있습니다. 다른 방법으로도 퍼즐을 풀 수 있지만 7턴보다 빠르게 풀 수는 없습니다.
 *
 * 입출력 예 #3
 * <img alt="rb_horse5.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/c6aed2ad-dbbf-477e-bac7-fd5cd44bad00/rb_horse5.jpg">
 * 다음 턴에 파란색 수레가 파란색 수레의 도착 칸에 위치한 후 고정되어 빨간색 수레가 빨간색 수레의 도착 칸에 도착할 수 없게 됩니다.
 * 퍼즐을 풀 수 없으므로 0을 return 해야 합니다.
 *
 * 입출력 예 #4
 * <img alt="rb_horse6.jpg" src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/0ff7e955-77d6-4760-9e16-75cf2313fc0d/rb_horse6.jpg">
 * 수레는 서로 위치를 바꾸면서 움직일 수 없으므로 퍼즐을 풀 수 없습니다. 따라서 0을 return 해야 합니다.
 */
public class Main {
    public static void main(String[] args) {

        int[][][] maze = {
                {{1, 4}, {0, 0}, {2, 3}},
                {{1, 0, 2}, {0, 0, 0}, {5, 0 ,5}, {4, 0, 3}},
                {{1, 5}, {2, 5}, {4, 5}, {3, 5}},
                {{4, 1, 2, 3}}
        };
        int[] result = {3, 7, 0, 0};

        for (int i = 0; i < result.length; i++) {
            int answer = new Solution().solution(maze[i]);
            System.out.println("case " + (i + 1) + "\n정답: " + result[i] + "\n풀이: " + answer + "\n");
        }
    }
}
