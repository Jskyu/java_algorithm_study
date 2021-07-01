package programmers.level1.KthNumber;

import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);

        for(int i = 0; i < answer.length; ++i) {
            System.out.println(answer[i]);
        }

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] number = new int[array.length];

        for(int i = 0; i < commands.length; ++i) {
            number = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(number);
            answer[i] = number[commands[i][2] - 1];
        }

        return answer;
    }
}