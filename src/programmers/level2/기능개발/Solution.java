package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds){
        List<Integer> list = new ArrayList<>();
        int days = 0;
        int[] complete = new int[progresses.length];
        for(int i = 0; i < complete.length; i++){
            complete[i] = 0;
        }
        int comp = 0;
        while(! (comp == progresses.length)){
            days++;
            for(int i = 0; i < progresses.length; i++){
                if(progresses[i] < 100){
                    progresses[i] += speeds[i];
                }
                if((progresses[i] >= 100) && (complete[i] == 0)){
                    complete[i] = days;
                    comp++;
                }
            }
        }

        int result = 1;
        days = 0;
        for(int i = 0; i < complete.length; i++){
            try{
                if(days < complete[i]){
                    days = complete[i];
                }
                if(days >= complete[i + 1]){
                    result++;
                } else{
                    list.add(result);
                    result = 1;
                }
            } catch(Exception e){
                list.add(result);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public int[] solution2(int[] progresses, int[] speeds){
        int[] answer;

        int k = 0;
        int complete = 0;

        ArrayList<Integer> a = new ArrayList<>();

        while(true){
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            if(progresses[k] >= 100){
                complete++;
                for(int i = k + 1; i < progresses.length; i++){
                    if(progresses[i] < 100){
                        k = i;
                        break;
                    } else complete++;
                    k++;
                }
                a.add(complete);
                complete = 0;
            }
            if(k == progresses.length - 1 && progresses[k] >= 100) break;
        }
        answer = new int[a.size()];

        for(int i = 0; i < a.size(); i++){
            answer[i] = a.get(i);
        }

        return answer;
    }
}
