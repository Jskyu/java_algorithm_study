package programmers.level1.removeTheSmallestNumber;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr){
        int[] answer;

        if(arr.length == 1){
            return new int[] {-1};
        } else{
            answer = new int[arr.length - 1];
            int min = arr[0];
            for(int i = 1; i < arr.length; i++){
                min = Math.min(min, arr[i]);
            }
            int j = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] != min){
                    answer[j] = arr[i];
                    j++;
                }
            }
        }
        return answer;
    }

    public int[] streamSolution(int[] arr){
        if(arr.length <= 1){
            return new int[]{- 1};
        }
        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(i -> i != min).toArray();

        /** Arrays.stream(arr).filter(i -> i != min).toArray(); 를 풀어서 쓴다면
         int[] result = new int[10];
         int count = 0;
         for(int i : arr){
            if(i != min){
                if(result.length == count){
                result = Arrays.copyOf(result, count * 2);
                }
                result[count++] = i;
            }
         }
         result = Arrays.copyOfRange(result, 0, count);
         return result;
         */



    }
}