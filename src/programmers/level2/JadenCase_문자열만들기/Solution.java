package programmers.level2.JadenCase_문자열만들기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String solution(String s) {
        String answer = Arrays.stream(s.split(" ")).map(str -> {
            if (str.length() > 1) {
                return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
            }
            return str.toUpperCase();
        }).collect(Collectors.joining(" "));

        if(s.length() != answer.length()) answer += " ";

        return answer;
    }
}