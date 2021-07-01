package programmers.level1.dividedArrayOfNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){

        int[] arr = {5, 9, 7, 10};
        int divisor = 5;

        for(int i : solution(arr, divisor)){
            System.out.print(" " + i);
        }
    }

    public static int[] solution(int[] arr, int divisor){
        List<Integer> list = new ArrayList<>();

        for(int i : arr){
            if(i % divisor == 0){
                list.add(i);
            }
        }

        if(list.size() == 0){
            list.add(- 1);
        }
        int[] answer = new int[list.size()];

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }
}
