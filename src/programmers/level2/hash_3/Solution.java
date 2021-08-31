package programmers.level2.hash_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> countMap = new HashMap<>();
        for (String[] cloth : clothes) {
            countMap.put(cloth[1], countMap.getOrDefault(cloth[1], 0) + 1);
        }
        for (int value : countMap.values()) {
            answer *= (value + 1);
        }

        return answer - 1;
    }

    public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream()
                .reduce(1L, (x, y) -> x * (y + 1))
                .intValue() - 1;
    }
}
