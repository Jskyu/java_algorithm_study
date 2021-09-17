package programmers.level1.addMissingNumbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[] numbers) {
        return IntStream.rangeClosed(0,9).sum() - Arrays.stream(numbers).sum();
    }
}