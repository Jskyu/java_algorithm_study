package programmers.level1.nNumbersSpacedByX;

public class Main {
    public static void main(String[] args){

        Solution solution = new Solution();

        int x = 4;
        int n = 3;

        for(long l : solution.solution(x, n)){
            System.out.print(l + "  ");
        }
    }
}
