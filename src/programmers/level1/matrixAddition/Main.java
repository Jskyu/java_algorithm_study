package programmers.level1.matrixAddition;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[][] arr1 = {{1}, {2}};
        int[][] arr2 = {{3}, {4}};
        for(int[] ints : solution.solution(arr1, arr2)){
            for(int anInt : ints){
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
