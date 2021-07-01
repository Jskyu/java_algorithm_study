package programmers.level1.athleteWhoCouldntFinish;

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();

        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};

        System.out.println(solution.solution(participant, completion));
    }
}
