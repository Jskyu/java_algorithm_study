package programmers.level1.fibonacciSequence;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        solution(10);
    }

    public static void solution(int n) {
        List<Integer> answer = new ArrayList<>();

        int fst = 1;
        int sec = 1;

        answer.add(fst);
        answer.add(sec);

        for(int i = 0 ; i < n; i++) {
            answer.add(fst+sec);
            fst += sec;
            answer.add(fst+sec);
            sec += fst;
            System.out.println(answer.get(i));
        }

    }
}