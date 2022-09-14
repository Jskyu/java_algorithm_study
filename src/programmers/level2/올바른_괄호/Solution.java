package programmers.level2.올바른_괄호;

public class Solution {
    boolean solution(String s) {
        if(s.length() % 2 == 1) return false;

        int num = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') num++;
            else num--;
            if(num < 0) return false;
        }

        return num == 0;
    }
}