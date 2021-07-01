package programmers.level1.sumOfTwoIntegers;

public class Main {
    public static void main(String[] args){
        System.out.println(solution(3, 5));
    }

    public static long solution(int a, int b){
        long answer = 0;

        while(a < b || b < a){
            if(a < b){
                answer += a;
                a++;
            } else if(b < a){
                answer += b;
                b++;
            }
        }
        answer += a;

        return answer;
    }
}
