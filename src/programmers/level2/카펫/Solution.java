package programmers.level2.카펫;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {0, 0};
        int sum = brown + yellow;

        List<Integer> list = new ArrayList<>(); // 공약수
        for (int i = 1; i <= sum; i++) {
            if(sum % i == 0) list.add(i);
        }
        int size = list.size();
        int temp = size / 2;

        if (size % 2 == 0) { // 가운데 2개
            int index = getYellow(list, yellow);
            return new int[]{list.get(temp + index), list.get(temp - 1 - index)};
        } else {
            answer = new int[]{list.get(temp), list.get(temp)};
        }

        return answer;
    }

    int getYellow(List<Integer> list, int target) {
        int size = list.size();
        int temp = size / 2;
        int result = 0;
        int index = -1;
        while (result != target) {
            index++;
            int x = list.get(temp + index);
            int y = list.get(temp - index - 1);
            result = getYellowCount(x, y);
        }
        return index;
    }

    int getYellowCount(int x, int y) {
        if (x <= 2 || y <= 2) return 0;
        return (x - 2) * (y - 2);
    }
}
