package programmers.level1.sortingAsYouLikeInStrings;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String[] strings = {"sun", "bed", "car"};
        int n = 1;

        for(int i = 0; i < solution(strings, n).length; i++){
            System.out.println("solution[" + i + "] : " + solution(strings, n)[i]);
        }
    }

    public static String[] solution(String[] strings, int n){
        String[] answer = new String[strings.length];

        for(int i = 0; i < strings.length; i++){
            answer[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(answer);

        for(int i = 0; i < answer.length; i++){
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }

}
