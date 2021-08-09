package programmers.level1.calculateTheShortfall;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int price = 3;
        int money = 20;
        int count = 4;

        long answer = s.solution(price, money, count);

        System.out.println("answer = " + answer);
    }
}
