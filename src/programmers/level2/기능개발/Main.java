package programmers.level2.기능개발;

public class Main {
    public static void main(String[] args){
        Solution solution = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        //                   7 , 3, 9, 7, 3, 9,10, 3, 9


        for(int i : solution.solution(progresses, speeds)){
            System.out.print(i + " ");
        }
        System.out.println("\n=================================");
        for(int i : solution.solution2(progresses, speeds)){
            System.out.print(i + " ");
        }
    }

}
