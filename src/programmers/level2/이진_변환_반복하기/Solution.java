package programmers.level2.이진_변환_반복하기;

public class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};

        while (s.length() > 1) {
            int length = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') answer[1]++;
                else length++;
            }
            s = Integer.toBinaryString(length);
            answer[0]++;
        }

        return answer;
    }
}
