package programmers.level2.문자열_압축;

import java.util.stream.IntStream;

public class Solution {
    public int solution(String s) {
        long start = System.currentTimeMillis();
        try {
            return IntStream.rangeClosed(1, s.length() / 2).map(i -> {
                int count = 1;
                String str = s.substring(0, i);
                StringBuilder result = new StringBuilder();

                for (int j = i; j <= s.length(); j += i) {
                    String next = s.substring(j, Math.min(i + j, s.length()));
                    if (str.equals(next)) count++;
                    else {
                        if (count != 1) result.append(count);
                        result.append(str);
                        str = next;
                        count = 1;
                    }
                }
                result.append(str);
                return result.length();
            }).min().orElse(s.length());
        } finally {
            long finish = System.currentTimeMillis();
            System.out.println("time : " + (finish - start) + "ms");
        }
    }
}
