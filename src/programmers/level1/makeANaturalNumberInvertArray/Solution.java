package programmers.level1.makeANaturalNumberInvertArray;

class Solution {
    public int[] solution(long n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] answer = new int[chars.length];
        int j = 0;
        for(int i = chars.length; i > 0; i--){
            answer[j] = Integer.parseInt(String.valueOf(chars[i-1]));
            j++;
        }
        return answer;
    }
}