package programmers.level1.makePrime;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return (int) list.stream().filter(this::isPrime).count();
    }

    private boolean isPrime(int i){
        int sqrt = (int) Math.sqrt(i) + 1;
        for(int j = 2; j < sqrt; j++){
            if (i % j == 0)
                return false;
        }
        return true;
    }
}
