package programmers.level1.phoneketmon;

import java.util.Arrays;

public class Solution {
    public int solution(int[] nums) {
        int max = nums.length / 2;
        long count = Arrays.stream(nums).distinct().count();
        return count > max ? max : (int) count;
    }
}
