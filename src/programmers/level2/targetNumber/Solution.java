package programmers.level2.targetNumber;

public class Solution {
    int TARGET = 0;
    int[] NUMBERS = new int[0];

    public int solution(int[] numbers, int target) {
        long start = System.currentTimeMillis();
        try {
            TARGET = target;
            NUMBERS = numbers;
            return getTargetCount(0, 0);
        } finally {
            System.out.println("time : " + (System.currentTimeMillis() - start) + "ms");
        }
    }

    private int getTargetCount(int number, int index) {
        if (index == NUMBERS.length) {
            if (number == TARGET) {
                return 1;
            }
            return 0;
        }
        return getTargetCount(number + NUMBERS[index], index + 1) +
                getTargetCount(number - NUMBERS[index], index + 1);
    }
}