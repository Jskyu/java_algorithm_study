package programmers.level1.Integer_descending_arrangement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public long solution(long n){

        String s = String.valueOf(n);
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            list.add(s.charAt(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        s = "";

        for(Character character : list){
            s += character;
        }

        return Long.parseLong(s);
    }

    private String res = "";
    public long solution2(long n){

        IntStream chars = Long.toString(n).chars();
        Long.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char) c) + res);
        return Long.parseLong(res);
    }
}
