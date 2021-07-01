package programmers.level1.findPrimeNumbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int n){
        List<Integer> list = new ArrayList<>();
        list.add(2);

        for(int i = 3; i <= n; i += 2){
            if(isPrime1(i)){
                list.add(i);
                System.out.println("i = " + i);
            }
        }
        return list.size();
    }

    private boolean isPrime1(int i){
        int sqrt = (int) Math.sqrt(i) + 1;
        for(int j = 2; j < sqrt; j++){
            if(i % j == 0)
                return false;
        }
        return true;
    }

    private boolean isPrime2(int i, List<Integer> list){
        for(int listValue : list){
            if(listValue * 2 > i){
                return true;
            }
            if(i % listValue == 0){
                return false;
            }
        }
        return true;
    }
}
