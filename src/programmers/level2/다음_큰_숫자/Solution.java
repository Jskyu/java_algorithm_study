package programmers.level2.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        int answer = n;
        int count = Integer.bitCount(n);
        while (count != Integer.bitCount(++answer)) {}

        return answer;
    }
}