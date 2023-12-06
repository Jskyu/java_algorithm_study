package programmers.pccp.t_1.n1_외톨이알파벳;

import java.util.*;

class Solution {
    public String solution(String input_string) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        String before = "";
        for(char c : input_string.toCharArray()) {
            if (before.equals("")) {
                before = "" + c;
            } else if (before.charAt(0) == c) {
                if (before.length() < 1)
                    before += c;
            } else {
                map.put(before, map.getOrDefault(before, 0) + 1);
                before = "" + c;
            }
        }
        map.put(before, map.getOrDefault(before, 0) + 1);

        for(String key : map.keySet()) {
            int value = map.get(key);
            if (value >= 2) {
                answer.append(key.charAt(0));
            }
        }

        return answer.length() == 0 ? "N" : answer.toString();
    }
}