package r2soft_test;

public class Main {
    public static void main(String[] args) {
        quiz1();
        quiz2();
    }

    /**
     * 문제 1. 정수 배열 n[] 에서 연속된 수의 합 중 가장 큰 수 찾기
     */
    public static void quiz1(){
        //주어진 값
        int[] n = {7, 5, -1, 52, -70, 20, 10, 8, -1, 50, -120};

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n.length; i++) {
            int sum = 0;
            for (int j = i; j < n.length; j++) {
                sum += n[j];
                max = Math.max(max, sum);
            }
        }

        System.out.println("max = " + max);
    }

    /**
     * 문제 2. n톤 의 무게를 옮기는데 a톤, b톤 트럭이 최소치로 왕복하는 횟수
     */
    public static void quiz2(){
        //주어진 값
        int n = 4;
        int a = 5;
        int b = 3;

        int max = Math.max(a, b);
        int min = Math.min(a, b);

        int maxCnt = 0; // 큰 트럭이 운반한 횟수
        int minCnt = 0; // 작은 트럭이 운반한 횟수
        boolean canMove = false;

        for (int i = n / a; i > 0 ; i--) {
            int temp = max * i; // 큰 무게 최대로 나누었을때
            if ((n - temp) % min == 0) {
                maxCnt = i;
                minCnt = (n - temp) / min;
                canMove = true;
                break;
            }
        }

        if (canMove) {
            System.out.println("큰 트럭 : " + maxCnt + "\n작은 트럭 : " + minCnt);
        }
        else {
            System.out.println("옮길 수 없습니다.");
        }
    }
}