package programmers.level1.createStrangeCharacters;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String s) {
        return answer3(s);
    }

    private String answer3(String s){
        String answer = "";
        int cnt = 0;
        String[] array = s.split("");

        for(String ss : array) {
            cnt = ss.contains(" ") ? 0 : cnt + 1;
            answer += cnt%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return answer;
    }

    private String answer2(String s){
        char[] chars = s.toCharArray();
        int idx = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ')
                idx = 0;
            else
                chars[i] = (idx++ % 2 == 0 ? Character.toUpperCase(chars[i]) : Character.toLowerCase(chars[i]));
        }

        return String.valueOf(chars);
    }

    private String answer1(String s, String answer){
        s = s.toLowerCase();
        List<String> list = new ArrayList<>();
        int j = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                list.add(s.substring(j, i));
                j = i+1;
            }
        }
        list.add(s.substring(j));

        for(String s1 : list){
            for(int i = 0; i < s1.length(); i++){
                if(i % 2 == 0){
                    answer += Character.toUpperCase(s1.charAt(i));
                }
                else
                    answer += Character.toLowerCase(s1.charAt(i));
            }
            answer += " ";
        }
        return answer;
    }
}
