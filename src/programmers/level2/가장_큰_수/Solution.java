package programmers.level2.가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] stringNumbers = new String[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            stringNumbers[i] = numbers[i]+"1";
        }
        Arrays.sort(stringNumbers);

        for(int i = stringNumbers.length - 1; i >= 0; i--){
            String substring = stringNumbers[i].substring(0, stringNumbers[i].length() - 1);
            answer.append(substring);
        }

        return answer.toString();
    }

    public String solution2(int[] numbers) {

        StringBuilder answer = new StringBuilder();
        String[] result = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (result[0].equals("0")) {
            return "0";
        }

        for (String a : result) {
            answer.append(a);
        }
        return answer.toString();
    }
}