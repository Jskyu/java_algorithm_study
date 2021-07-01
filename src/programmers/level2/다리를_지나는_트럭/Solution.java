package programmers.level2.다리를_지나는_트럭;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights){
        int answer = 0;
        int nowWeight = 0;
        Map<Integer, Integer> nowTrucks = new HashMap<>();
        List<Integer> trucks = new ArrayList<>();

        for(int truck_weight : truck_weights){
            trucks.add(truck_weight);
        }

        while(trucks.size() > 0){
            answer++;

            //남은거리 -1
            for(Integer key : new ArrayList<>(nowTrucks.keySet())){
                nowTrucks.put(key, nowTrucks.get(key) - 1);
                //만약 이동을 끝냈다면
                if(nowTrucks.get(key) == 0){
                    //다리 위에 있는 트럭 정보 삭제
                    nowTrucks.remove(key);
                    //현재 다리가 지탱하고 있는 무게 - 지나간 트럭의 무게
                    nowWeight -= key;
                }
            }

            //현재 지탱하고 있는 무게 + 대기 1번 트럭의 무게 <= 다리가 지탱할수 있는 무게
            if(nowWeight + trucks.get(0) <= weight){
                //현재 건너고 있는 트럭 맵에 추가
                nowTrucks.put(trucks.get(0), bridge_length);
                //현재 지탱하고 있는 무게 추가
                nowWeight += trucks.get(0);
                //대기중인 트럭 삭제
                trucks.remove(0);
            }
        }

        return answer+bridge_length;
    }

    public int solution2(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new ConcurrentLinkedQueue<>();
        int sum = 0;
        for(int t : truck_weights) {
            while(true) {
                if(q.isEmpty()) {
                    q.add(t);
                    sum += t;
                    answer++;
                    break;
                } else if(q.size() == bridge_length) {
                    sum -= q.poll();
                } else {
                    if(sum + t > weight) {
                        answer++;
                        q.add(0);
                    } else {
                        q.add(t);
                        sum+=t;
                        answer++;
                        break;
                    }
                }
            }
        }
        return answer + bridge_length;
    }
}