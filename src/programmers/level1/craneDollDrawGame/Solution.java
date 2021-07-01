package programmers.level1.craneDollDrawGame;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int depth = 0;

        List<Integer> doll = new ArrayList<>();

        for(int move : moves){
            for(int j = 0; j < board.length; j++){
                if(board[depth][move - 1] == 0){
                    depth++;
                } else{
                    break;
                }
            }

            if(depth != board.length){
                doll.add(board[depth][move - 1]);
                board[depth][move - 1] = 0;
            }
            depth = 0;
        }

        while(true) {
            boolean check = false;
            for(int i=0; i<doll.size()-1; i++) {
                if(doll.get(i).equals(doll.get(i + 1))) {
                    answer += 2;
                    doll.remove(i+1);
                    doll.remove(i);
                    check = true;
                }
            }
            if(! check) break;
        }

        return answer;
    }
}