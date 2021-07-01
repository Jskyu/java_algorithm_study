package programmers.level2._124나라의_숫자;

class Solution {
    public String solution(int n) {

        String answer = "";
        int addNum = 0;
        while(n != 0) {
            addNum = n%3 == 0 ? 4 : n%3;
            answer = addNum + answer;
            n = addNum == 4 ? n/3 - 1 : n/3;
        }

        return answer;
    }

    public String solution2(int n) {
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}