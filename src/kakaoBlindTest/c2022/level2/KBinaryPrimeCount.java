package kakaoBlindTest.c2022.level2;

import java.util.Stack;

/**
 * 진수에서 소수 개수 구하기
 * 문제 설명
 * 문제 설명
 * 양의 정수 n이 주어집니다. 이 숫자를 k진수로 바꿨을 때, 변환된 수 안에 아래 조건에 맞는 소수(Prime number)가 몇 개인지 알아보려 합니다.
 * <p>
 * 0P0처럼 소수 양쪽에 0이 있는 경우
 * P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
 * 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
 * P처럼 소수 양쪽에 아무것도 없는 경우
 * 단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
 * 예를 들어, 101은 P가 될 수 없습니다.
 * 예를 들어, 437674을 3진수로 바꾸면 211020101011입니다. 여기서 찾을 수 있는 조건에 맞는 소수는 왼쪽부터 순서대로 211, 2, 11이 있으며, 총 3개입니다. (211, 2, 11을 k진법으로 보았을 때가 아닌, 10진법으로 보았을 때 소수여야 한다는 점에 주의합니다.) 211은 P0 형태에서 찾을 수 있으며, 2는 0P0에서, 11은 0P에서 찾을 수 있습니다.
 * <p>
 * 정수 n과 k가 매개변수로 주어집니다. n을 k진수로 바꿨을 때, 변환된 수 안에서 찾을 수 있는 위 조건에 맞는 소수의 개수를 return 하도록 solution 함수를 완성해 주세요.
 * <p>
 * 제한사항
 * 1 ≤ n ≤ 1,000,000
 * 3 ≤ k ≤ 10
 * 입출력 예
 * n	        k	result
 * 437674	    3	3
 * 110011	    10	2
 */
public class KBinaryPrimeCount {
    public static void main(String[] args) {
        //given
        int n = 110011;
        int k = 10;

        //when
        int result = solution(n, k);

        //then
        System.out.println("3 == " + result + ": " + (result == 2));
    }

    private static int solution(int n, int k) {
        String transN = transNumber(n, k);
        int count = 0;

        char[] chars = transN.toCharArray();

        StringBuilder prime = new StringBuilder();
        for (char c : chars) {
            if (c == '0') {
                if (!prime.toString().equals("")) {
                    if (checkPrime(Long.parseLong(prime.toString()))) {
                        count++;
                    }
                }
                prime = new StringBuilder();
            } else {
                prime.append(c);
            }
        }
        if (!prime.toString().equals("")) {
            if (checkPrime(Long.parseLong(prime.toString()))) {
                count++;
            }
        }

        return count;
    }

    private static boolean checkPrime(long number) {
        if (number == 1) return false;
        else if (number == 2) return true;
        long sqrt = (long) Math.sqrt(number);
        for (long i = 2; i <= sqrt; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    private static String transNumber(int n, int k) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            stack.push(n % k);
            n /= k;
        }
        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    public static int solution2(int n, int k) {

        int ans = 0;
        String[] temp = Integer.toString(n, k).split("0");

        Loop:
        for (String t : temp) {
            System.out.println("t = " + t);
            if (t.length() == 0) continue;
            long a = Long.parseLong(t);
            if (a == 1) continue;
            for (int i = 2; i <= Math.sqrt(a); i++)
                if (a % i == 0) continue Loop;

            ans++;
        }

        return ans;
    }

}
