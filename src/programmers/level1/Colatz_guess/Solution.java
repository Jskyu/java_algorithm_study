package programmers.level1.Colatz_guess;

class Solution {
    public int solution(int num) {
        int answer = 0;
        long l = Long.parseLong(String.valueOf(num));

        while(true){
            if(l == 1){
                return answer;
            }
            else if(answer >= 500){
                return -1;
            }
            l = l % 2 == 0 ? l / 2 : (l * 3) + 1;
            answer++;
        }
    }
}