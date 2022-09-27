package programmers.level2.괄호_회전하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private final List<Character> open = new ArrayList<>();
    private final List<Character> close = new ArrayList<>();

    public int solution(String s) {
        init();
        if(s.length() % 2 == 1) return 0;
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            String str = sb.substring(i) + sb.substring(0, i);
            if(isCorrect(str)) answer++;
        }

        return answer;
    }

    private boolean isCorrect(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if(open.contains(c)) {
                stack.add(c);
                continue;
            }
            if(stack.isEmpty()) return false;
            Character pop = close.get(open.indexOf(stack.pop()));
            if (!(pop == c)) {
                return false;
            }
        }
        return true;
    }

    private void init(){
        this.open.add('(');
        this.open.add('[');
        this.open.add('{');

        this.close.add(')');
        this.close.add(']');
        this.close.add('}');
    }
}