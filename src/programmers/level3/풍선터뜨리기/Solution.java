package programmers.level3.풍선터뜨리기;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] a) {
        if(a.length <= 2) return a.length;

        Set<Integer> lived = new HashSet<>();

        //살리려는 풍선의 앞, 뒤중 가장 낮은 숫자가 1개 이하면 살 수 있다.
        int min = Integer.MAX_VALUE;

        for (int i : a) {
            if(min > i) {
                min = i;
                lived.add(i);
            }
        }
        min = Integer.MAX_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            if(min > a[i]){
                min = a[i];
                lived.add(a[i]);
            }
        }

        return lived.size();
    }
}