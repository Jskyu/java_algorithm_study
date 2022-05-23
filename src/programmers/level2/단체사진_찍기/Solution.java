package programmers.level2.단체사진_찍기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> list = new ArrayList<>();
    private String[] data;

    public int solution(int n, String[] data) {
        long start = System.currentTimeMillis();
        try {
            String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
            for (int i = 0; i < friends.length; i++) {
                dfs(friends, i, 0, new StringBuilder());
            }
            this.data = data;
            return (int) list.stream().filter(this::checkCondition).count();
        } finally {
            long time = System.currentTimeMillis() - start;
            System.out.println("time = " + time + "ms");
        }
    }

    private boolean checkCondition(String position) {
        for (String str : data) {
            String sign = str.substring(3, 4);
            int cond = Integer.parseInt(str.substring(4, 5));
            int interval = Math.abs(position.indexOf(str.charAt(0)) - position.indexOf(str.charAt(2))) - 1;
            switch (sign) {
                case "=":
                    if (interval != cond) return false;
                    continue;
                case "<":
                    if (interval >= cond) return false;
                    continue;
                case ">":
                    if (interval <= cond) return false;
            }
        }
        return true;
    }

    private void dfs(String[] friends, int index, int dept, StringBuilder sb) {
        if (dept == 7) {
            list.add(sb.toString());
            return;
        }
        sb.append(friends[index]);
        String[] arr = new String[friends.length - 1];
        int j = 0;
        for (int i = 0; i < friends.length; i++) {
            if (i == index) continue;
            arr[j++] = friends[i];
        }
        j = 0;
        for (int i = 0; i < friends.length; i++) {
            if (i == index) continue;
            dfs(arr, j++, dept + 1, new StringBuilder(sb.toString()));
        }
    }
}