package programmers.level2.소수_찾기;

import java.util.*;

public class Solution {

    private Set<Integer> set = new HashSet<>();
    private int size = 0;

    public int solution(String numbers) {
        size = numbers.length();
        List<Character> list = new ArrayList<>();
        for (char c : numbers.toCharArray()) {
            list.add(c);
        }
        for (int i = 0; i < numbers.length(); i++) {
            dfs(new ArrayList<>(list), i, 0, new StringBuilder());
        }

        return (int) set.stream().filter(this::isPrime).count();
    }

    private void dfs(List<Character> list, int index, int dept, StringBuilder sb) {
        if(dept == size) return;
        sb.append(list.get(index));
        list.remove(index);
        set.add(Integer.parseInt(sb.toString()));
        for (int i = 0; i < list.size(); i++) {
            dfs(new ArrayList<>(list), i, dept + 1, new StringBuilder(sb.toString()));
        }
    }

    private boolean isPrime(int i){
        if(i == 0 || i == 1) return false;
        int sqrt = (int) Math.sqrt(i) + 1;
        for(int j = 2; j < sqrt; j++){
            if (i % j == 0)
                return false;
        }
        System.out.println("sqrt = " + i);
        return true;
    }
}
