package programmers.level2.heap_1;


public class Main {
    public static void main(String[] args) {
        MoreSpicy s1 = new MoreSpicy();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        int moreSpicy = s1.solution(scoville, k);
        System.out.println("moreSpicy = " + moreSpicy);


    }
}
