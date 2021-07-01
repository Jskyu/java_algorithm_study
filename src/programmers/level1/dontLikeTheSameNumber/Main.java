package programmers.level1.dontLikeTheSameNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        for(int i = 0; i < solution(arr).length; i++){
            System.out.print(" " + solution(arr)[i]);
        }
    }

    public static int[] solution(int[] arr){
        int j = 0;

        List<Integer> answerList = new ArrayList<>();
        answerList.add(arr[0]);

        for(int i = 1; i < arr.length; i++){
            if(answerList.get(j) != arr[i]){
                j++;
                answerList.add(arr[i]);
            }
        }
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i).intValue();
        }

        return answer;
    }
}
