package programmers.level2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 0;

        //등차수열
        for (int i = 1; n - ((i * (i - 1)) / 2) > 0; i++) {
            if ((n - ((i * (i - 1)) / 2)) % i == 0) {
                answer++;
            }
        }
        return answer;
    }
}