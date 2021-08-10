package programmers.level1.mutualEvaluation;

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < scores[0].length; j++) {
            int max = 0;
            int min = 100;
            int cnt = 0;
            int sum = 0;
            for (int i = 0; i < scores.length; i++) {
                sum += scores[i][j];
                if (scores[j][j] == scores[i][j]) {
                    cnt++;
                }
                max = Math.max(max, scores[i][j]);
                min = Math.min(min, scores[i][j]);
            }
            int num = scores.length;
            if (cnt == 1 && (scores[j][j] == max || scores[j][j] == min)) {
                sum -= scores[j][j];
                num--;
            }
            int score = sum / num;
            if (score >= 90) {
                sb.append('A');
            } else if (score >= 80) {
                sb.append('B');
            } else if (score >= 70) {
                sb.append('C');
            } else if (score >= 50) {
                sb.append('D');
            } else {
                sb.append('F');
            }
        }
        answer = sb.toString();
        return answer;
    }
}