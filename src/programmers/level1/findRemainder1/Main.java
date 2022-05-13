package programmers.level1.findRemainder1;

/**
 * <a href="https://programmers.co.kr/learn/courses/30/lessons/87389">https://programmers.co.kr/learn/courses/30/lessons/87389</a>
 * 나머지가 1이 되는 수 찾기
 * 문제 설명
 * 자연수 n이 매개변수로 주어집니다.
 * n을 x로 나눈 나머지가 1이 되도록 하는 가장 작은 자연수 x를 return 하도록 solution 함수를 완성해주세요.
 * 답이 항상 존재함은 증명될 수 있습니다.
 *
 * 제한사항
 * 3 ≤ n ≤ 1,000,000
 * 입출력 예
 * n	result
 * 10	3
 * 12	11
 */
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n = 950552;
        int result = s.solution(n);

        System.out.println("result = " + result);
    }
}
