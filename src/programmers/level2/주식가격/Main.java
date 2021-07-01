package programmers.level2.주식가격;

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};

        for(int i : solution.solution(prices)){
            System.out.print(i + " ");
        }
    }
}
