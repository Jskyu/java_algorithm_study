package programmers.level2.짝지어제거하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(stack.size() == 0) stack.push(c);
            else if(stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        return stack.size() == 0 ? 1 : 0;
    }
}