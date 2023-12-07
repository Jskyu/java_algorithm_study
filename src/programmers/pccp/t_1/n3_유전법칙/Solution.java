package programmers.pccp.t_1.n3_유전법칙;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String[] solution(int[][] queries) {
        String[] arr = {"RR", "Rr", "Rr", "rr"};

        return Arrays.stream(queries)
                .map(query -> {
                    String parent = "Rr";
                    int n = query[0];
                    int p = query[1] - 1;

                    Stack<Integer> stack = new Stack<>();
                    for (int i = 0; i < n - 1; i++) {
                        stack.add(p % 4);
                        p /= 4;
                    }

                    while (!stack.isEmpty()) {
                        int now = stack.pop();
                        if (parent.equals("RR") || parent.equals("rr")) {
                            return parent;
                        }

                        parent = arr[now];
                    }
                    return parent;
                })
                .toArray(String[]::new);
    }
}